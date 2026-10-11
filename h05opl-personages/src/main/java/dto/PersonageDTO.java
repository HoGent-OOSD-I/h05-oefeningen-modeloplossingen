package dto;

public record PersonageDTO(String naam, CategorieDTO categorie) {   // categorie mag geen domeinklasse zijn! Moet ook een DTO zijn
}