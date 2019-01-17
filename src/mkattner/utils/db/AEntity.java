package mkattner.utils.db;

import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class AEntity implements IEntity{
    // private static final ObjectMapper objectMapper = new ObjectMapper();
    static {
	// objectMapper.readValue(new File("config/database.json"), Database.class)
    }

    protected static String getSqlSelect(String tableName) {
	tableName = tableName + ".";
	return tableName + "id, UNIX_TIMESTAMP(" + tableName + "timestamp) as timestamp, UNIX_TIMESTAMP(" + tableName + "updated) as updated, " + tableName + "deleted ";
    }

    protected Boolean deleted;

    protected Long id;

    // protected abstract static void sadf();
    protected Long timestamp;

    protected Long updated;

    public AEntity() {
	// TODO Auto-generated constructor stubs
    }

    public AEntity(long id, long timestamp, long updated, boolean deleted) {
	this.setEntity(id, timestamp, updated, deleted);
    }

    public Boolean getDeleted() {
	return deleted;
    }

    public Long getId() {
	return id;
    }

    public Long getTimestamp() {
	return timestamp;
    }

    public Long getUpdated() {
	return updated;
    }

    public void setDeleted(Boolean deleted) {
	this.deleted = deleted;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public void setTimestamp(Long timestamp) {
	this.timestamp = timestamp;
    }

    public void setUpdated(Long updated) {
	this.updated = updated;
    }

    protected void setEntity(long id, long timestamp, long updated, boolean deleted) {
	this.setId(id);
	this.setTimestamp(timestamp);
	this.setUpdated(updated);
	this.setDeleted(deleted);
    }

    protected void setEntity(ResultSet resultSet) throws SQLException {
	this.setEntity(resultSet.getLong("id"), resultSet.getLong("timestamp"), resultSet.getLong("updated"), resultSet.getBoolean("deleted"));
    }

    // @JsonIgnore
    // protected abstract Table getTable();
}
