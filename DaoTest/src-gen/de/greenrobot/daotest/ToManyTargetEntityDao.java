package de.greenrobot.daotest;

import java.util.List;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.DaoConfig;
import de.greenrobot.dao.IdentityScope;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.Query;
import de.greenrobot.dao.QueryBuilder;

import de.greenrobot.daotest.ToManyTargetEntity;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table TO_MANY_TARGET_ENTITY (schema version 1).
*/
public class ToManyTargetEntityDao extends AbstractDao<ToManyTargetEntity, Long> {

    public static final String TABLENAME = "TO_MANY_TARGET_ENTITY";

    public static class Properties {
        public final static Property ToManyId = new Property(0, Long.class, "toManyId", false, "TO_MANY_ID");
        public final static Property Id = new Property(1, Long.class, "id", true, "_id");
    };

    private Query toManyEntity_ToManyTargetEntityQuery;

    public ToManyTargetEntityDao(DaoConfig config) {
        super(config);
    }
    
    public ToManyTargetEntityDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String sql = "CREATE TABLE " + (ifNotExists? "IF NOT EXISTS ": "") + "'TO_MANY_TARGET_ENTITY' (" + //
                "'TO_MANY_ID' INTEGER," + // 0: toManyId
                "'_id' INTEGER PRIMARY KEY );"; // 1: id
        db.execSQL(sql);
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'TO_MANY_TARGET_ENTITY'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, ToManyTargetEntity entity) {
        stmt.clearBindings();
 
        Long toManyId = entity.getToManyId();
        if (toManyId != null) {
            stmt.bindLong(1, toManyId);
        }
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(2, id);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1);
    }    

    /** @inheritdoc */
    @Override
    public ToManyTargetEntity readEntity(Cursor cursor, int offset) {
        ToManyTargetEntity entity = new ToManyTargetEntity( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // toManyId
            cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1) // id
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, ToManyTargetEntity entity, int offset) {
        entity.setToManyId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setId(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
     }
    
    @Override
    protected Long updateKeyAfterInsert(ToManyTargetEntity entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(ToManyTargetEntity entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "toManyTargetEntity" to-many relationship of ToManyEntity. */
    @SuppressWarnings("unchecked")
    public synchronized List<ToManyTargetEntity> _queryToManyEntity_ToManyTargetEntity(Long toManyId) {
        if (toManyEntity_ToManyTargetEntityQuery == null) {
            QueryBuilder<ToManyTargetEntity> queryBuilder = queryBuilder();
            queryBuilder.where(Properties.ToManyId.eq(toManyId));
            toManyEntity_ToManyTargetEntityQuery = queryBuilder.build();
        } else {
            toManyEntity_ToManyTargetEntityQuery.setParameter(0, toManyId);
        }
        return toManyEntity_ToManyTargetEntityQuery.list();
    }

}