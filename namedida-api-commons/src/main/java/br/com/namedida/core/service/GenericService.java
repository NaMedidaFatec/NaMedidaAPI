package br.com.namedida.core.service;

import br.com.namedida.core.business.BusinessError;
import br.com.namedida.core.business.IRule;
import br.com.namedida.core.business.IValidation;
import br.com.namedida.core.business.Result;
import br.com.namedida.core.persistence.GenericRepository;
import br.com.namedida.domain.EntidadeDominio;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public abstract class GenericService<T extends EntidadeDominio> {

    protected GenericRepository<T> repository;
    protected List<IValidation<T>> saveValidations;
    protected List<IValidation<T>> updateValidations;
    protected List<IValidation<T>> deleteValidations;
    protected Result result;

    public GenericService() {
        this.saveValidations = new ArrayList<>();
        this.updateValidations = new ArrayList<>();
        this.deleteValidations = new ArrayList<>();
        this.result = new Result();
    }

    public Result findAll() {
        this.result.setData(repository.findAll());
        return this.result;
    }

    public Result findAllEnabled(boolean enabled) {
        this.result.setData(repository.findAllByEnabled(enabled));
        return this.result;
    }

    public Result findOne(Long id) {
        this.result.setData(repository.findById(id).get());
        return this.result;
    }

    public Result save(T entity) {
        this.executeRules(saveValidations, entity);
        if (!this.result.hasErrors()) {
            this.result.setData(repository.save(entity));
        }
        return this.result;
    }

    public Result update(T entity, Long id) {
        entity.setId(id);
        this.executeRules(updateValidations, entity);
        if (!this.result.hasErrors()) {
            this.result.setData(repository.save(entity));
        }
        return this.result;
    }

    public Result toggleEnabledEntity(Long id) {
        try {
            T entity = this.repository.findById(id).get();
//            this.executeRules(deleteValidations, entity);
            if (!this.result.hasErrors()) {
                entity.setEnabled(!entity.getEnabled());
                this.result.setData(repository.save(entity));
            }
        } catch (NoSuchElementException e) {
            this.result.addError(new BusinessError("Entidade não encontrada"));
        }
        return this.result;
    }

    public Result delete(Long id) {
        try {
            T entity = this.repository.findById(id).get();
            this.executeRules(deleteValidations, entity);
            if (!this.result.hasErrors()) {
                entity.setEnabled(false);
                repository.save(entity);
            }
        } catch (NoSuchElementException e) {
            this.result.addError(new BusinessError("Entidade não encontrada"));
        }
        return this.result;
    }

    /**
     * 
     * @param rules
     * @param entity
     */
    public void executeRules(List<? extends IRule<T>> rules, T entity) {
        this.result = new Result();

        rules.forEach(rule -> {
            Result partial = rule.execute(entity);

            if (partial.hasErrors()) {
                this.result.appendErrors(partial);
            }
        });
    }
}
