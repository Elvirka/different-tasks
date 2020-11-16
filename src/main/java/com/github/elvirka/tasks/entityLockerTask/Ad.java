package com.github.elvirka.tasks.entityLockerTask;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Ad implements Entity<String> {
    private final String  id;
    private Set<String> keywords;

    private Ad(String id, Set<String> keywords) {
        this.id = id;
        this.keywords = new HashSet<>(keywords);
    }

    public String getId() {
        return id;
    }

    public Set<String> getKeywords() {
        return new HashSet<>(keywords);
    }

    public void setKeywords(Set<String> keywords) {
        if (!this.keywords.equals(keywords)){
            this.keywords = new HashSet<>(keywords);
        }
    }

    @Override
    public String toString() {
        return "Ad{" +
                "id='" + id + '\'' +
                ", keywords=" + keywords +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ad ad = (Ad) o;

        if (!Objects.equals(id, ad.id)) return false;
        return Objects.equals(keywords, ad.keywords);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (keywords != null ? keywords.hashCode() : 0);
        return result;
    }

    public static Ad valueOf(String id, Set<String> keywords){
        return new Ad(id, keywords);
    }
}
