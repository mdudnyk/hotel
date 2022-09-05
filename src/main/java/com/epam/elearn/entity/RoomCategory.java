package com.epam.elearn.entity;

import java.io.Serializable;
import java.util.Objects;

public class RoomCategory implements Serializable {
    private int id;
    private String title;
    private int priceDefault;
    private int area;
    private int guestsCapacity;
    private String description;

    public RoomCategory(final int id, final String title, final int priceDefault, final int area, final int guestsCapacity, final String description) {
        this.id = id;
        this.title = title;
        this.priceDefault = priceDefault;
        this.area = area;
        this.guestsCapacity = guestsCapacity;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public int getPriceDefault() {
        return priceDefault;
    }

    public void setPriceDefault(final int priceDefault) {
        this.priceDefault = priceDefault;
    }

    public int getArea() {
        return area;
    }

    public void setArea(final int area) {
        this.area = area;
    }

    public int getGuestsCapacity() {
        return guestsCapacity;
    }

    public void setGuestsCapacity(final int guestsCapacity) {
        this.guestsCapacity = guestsCapacity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final RoomCategory that = (RoomCategory) o;
        return id == that.id && priceDefault == that.priceDefault
                && area == that.area
                && guestsCapacity == that.guestsCapacity
                && title.equals(that.title)
                && description.equals(that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, priceDefault, area, guestsCapacity, description);
    }
}
