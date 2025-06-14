package com.AWS.Figma.Category.Query;

public class BrandQuery {
    public static final String FIND_BRAND_BY_ID = """
        SELECT * FROM Brand WHERE id = :id
    """;
    public static final String UPDATE_BRAND_BY_ID =
          //  "UPDATE brand SET name = ? WHERE id = ?";
          //  "update Brand b set b.name = :name where b.id = :id";
//            "SELECT b.id, c.id, c.name, b.name FROM brand b LEFT JOIN category c ON c.id = b.category_id WHERE b.id = :id";
            "UPDATE brand SET name = :name WHERE id = :id";
}

