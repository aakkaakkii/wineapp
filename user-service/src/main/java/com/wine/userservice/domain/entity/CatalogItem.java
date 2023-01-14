package com.wine.userservice.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
@Table(name = "list_catalogs")
@IdClass(CatalogItem.class)
public class CatalogItem implements AbstractEntity<Long>, Serializable {
    @Id
    @JoinColumn(name = "catalog_id", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Catalog catalog;

    @Id
    @JoinColumn(name = "item_id", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Item item;
}
