package com.AWS.Figma.Category.DAO;

import com.AWS.Figma.Category.Entity.Brand;
import com.AWS.Figma.Category.Query.BrandQuery;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class BrandDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Optional<Brand> findById(long id) {
        try {
            Brand brand = (Brand) entityManager.createNativeQuery(BrandQuery.FIND_BRAND_BY_ID, Brand.class)
                    .setParameter("id", id)
                    .getSingleResult();
            return Optional.ofNullable(brand);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
    public Brand editBrand(Brand brand) {
        entityManager.createNativeQuery(BrandQuery.UPDATE_BRAND_BY_ID)
                .setParameter("name", brand.getName())
                .setParameter("id",   brand.getId())
                .executeUpdate();

        // keep the in‑memory entity consistent
        return brand;
    }
}

