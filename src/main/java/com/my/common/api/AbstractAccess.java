package com.my.common.api;

import com.my.common.api.pagination.PageRequest;
import com.my.common.api.pagination.PageResult;
import jakarta.inject.Inject;
import lombok.NonNull;

import java.util.List;
import java.util.Optional;

public abstract class AbstractAccess<REPOSITORY extends Repository<T, ID>, T, ID extends Identifiable> implements Access<T, ID> {

    protected final REPOSITORY repository;

    @Inject
    protected AbstractAccess(REPOSITORY repository) {
        this.repository = repository;
    }

    @Override
    public Optional<T> getById(@NonNull ID id) {
        return repository.findById(id);
    }

    @Override
    public List<T> getAll() {
        return repository.findAll();
    }

    @Override
    public List<T> getAllByUser(UserId userId) {
        return repository.findAllByUser(userId);
    }

    @Override
    public PageResult<T> getAllByUser(UserId userId, PageRequest pageRequest) {
        return repository.findAllByUser(userId, pageRequest);
    }

    @Override
    public T save(T item) {
        if (isNew(item))
            return repository.save(item);
        else
            return repository.update(item);
    }

    @Override
    public void delete(T item) {
        repository.deleteById(getId(item));
    }

    protected abstract boolean isNew(T item);

    protected abstract ID getId(T item);
}
