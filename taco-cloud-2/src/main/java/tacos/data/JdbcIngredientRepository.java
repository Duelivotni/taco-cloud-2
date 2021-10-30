package tacos.data;

import org.springframework.stereotype.Repository;

import tacos.Ingredient;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.swing.plaf.ListUI;

import com.google.common.util.concurrent.ServiceManager.Listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

@Repository
public class JdbcIngredientRepository implements IngredientRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcIngredientRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Iterable<Ingredient> findAll() {
        return jdbcTemplate.query(
            "select id, name, type from Ingredient", this :: mapRowToIngredient);
    }

    @Override
    public Optional<Ingredient> findById(String id) {
        List<Ingredient> result = jdbcTemplate.query(
            "select id, name, type from Ingredient where id=?", this :: mapRowToIngredient, id);
        return result.size() == 0 ? Optional.empty() : Optional.of(result.get(0));    
    }

    private Ingredient mapRowToIngredient(ResultSet row, int rowNum) throws SQLException {
        return new Ingredient(row.getString("id"), 
        row.getString("name"),
        Ingredient.Type.valueOf(row.getString("type")));
    }
}
