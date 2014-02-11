package calculotochos.data;

import calculotochos.Utils;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.constraints.UniqueFieldValueConstraintViolationException;
import com.db4o.ext.DatabaseClosedException;
import com.db4o.ext.DatabaseFileLockedException;
import com.db4o.ext.DatabaseReadOnlyException;
import com.db4o.ext.Db4oIOException;
import com.db4o.ext.IncompatibleFileFormatException;
import com.db4o.ext.OldFormatException;
import com.db4o.query.Predicate;
import com.db4o.query.Query;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Maxi
 */
public class PerfilProvider {

    ObjectContainer db = null;

    public PerfilProvider() throws DatabaseFileLockedException, DatabaseReadOnlyException,
            Db4oIOException, IncompatibleFileFormatException, OldFormatException {
        this.db = new DataProvider().getDB();
    }

    public void add(Perfil data) throws DatabaseClosedException, DatabaseReadOnlyException {
        data.setFua(Utils.getDate());
        db.store(data);
    }

    public void update(Perfil data) throws DatabaseClosedException, DatabaseReadOnlyException {
        data.setFua(Utils.getDate());
        db.store(data);
    }

    public void delete(Perfil data) throws DatabaseClosedException, DatabaseReadOnlyException, Db4oIOException {
        db.delete(getOne(data));
    }

    /**
     *
     * @throws DatabaseClosedException
     * @throws DatabaseReadOnlyException
     * @throws Db4oIOException
     * @throws UniqueFieldValueConstraintViolationException
     */
    public void commit() throws DatabaseClosedException, DatabaseReadOnlyException, Db4oIOException,UniqueFieldValueConstraintViolationException {
        db.commit();
    }

    public void rollback() throws DatabaseClosedException, DatabaseReadOnlyException, Db4oIOException {
        db.rollback();
    }

    public void closeDB() throws Db4oIOException {
        db.close();
    }

    public ObjectSet<Perfil> getAll() throws DatabaseClosedException, Db4oIOException {
        return db.queryByExample(Perfil.class);
    }

    public Perfil getOne(final Perfil perfil) {
        List<Perfil> perfiles;
        perfiles = db.query(new Predicate<Perfil>() {
            @Override
            public boolean match(Perfil p) {
                return p.getId().equals(perfil.getId());
            }

        });
        Perfil result = perfiles.get(0);
        return result;
    }

    public ObjectSet<Perfil> search(String consulta) {
        final Query q = db.query();
        q.constrain(Perfil.class);
        q.descend("id").constrain(consulta).or(q.descend("nombre").constrain(consulta).like());
        ObjectSet<Perfil> result = q.execute();
        return result;
    }
}
