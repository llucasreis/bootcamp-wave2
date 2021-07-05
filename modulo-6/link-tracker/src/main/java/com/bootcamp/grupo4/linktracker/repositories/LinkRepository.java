package com.bootcamp.grupo4.linktracker.repositories;

import com.bootcamp.grupo4.linktracker.entities.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LinkRepository {
    private List<Link> links;

    public LinkRepository() {
        this.links = new ArrayList<>();
    }

    private Long getLastId() {
        if (this.links.size() == 0) {
            return 1L;
        }
        Link lastLink = this.links.get(this.links.size() - 1);
        return lastLink.getId() + 1;
    }

    public Link criar(Link link) {
        link.setId(this.getLastId());
        this.links.add(link);

        return link;
    }

    public Link findLinkById(Long id) {
        return this.links.stream().filter(l -> l.getId().equals(id)).findFirst().orElse(null);
    }

    public Link atualizarLink(Link link) {
        int index = this.links.indexOf(link);

        this.links.set(index, link);

        return link;
    }
}
