package calculotochos.data;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.ext.DatabaseClosedException;
import com.db4o.ext.DatabaseFileLockedException;
import com.db4o.ext.DatabaseReadOnlyException;
import com.db4o.ext.Db4oIOException;
import com.db4o.ext.IncompatibleFileFormatException;
import com.db4o.ext.OldFormatException;
import com.db4o.query.Query;

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
        db.store(data);
    }

    public void update(Perfil data) throws DatabaseClosedException, DatabaseReadOnlyException {
        db.store(data);
    }

    public void delete(Perfil data) throws DatabaseClosedException, DatabaseReadOnlyException, Db4oIOException {
        db.delete(data);
    }

    public void commit() throws DatabaseClosedException, DatabaseReadOnlyException, Db4oIOException {
        db.commit();
        db.close();
    }

    public void rollback() throws DatabaseClosedException, DatabaseReadOnlyException, Db4oIOException {
        db.rollback();
    }

    public ObjectSet<Perfil> getAll() throws DatabaseClosedException, Db4oIOException {
        return db.queryByExample(Perfil.class);
    }

    public ObjectSet<Perfil> search(String consulta) {
        final Query q = db.query();
        q.constrain(Perfil.class);
        q.descend("id").constrain(consulta)
                .or(q.descend("nombre").constrain(consulta).like()).like();
        ObjectSet<Perfil> result = q.execute();
        return result;
    }
}
