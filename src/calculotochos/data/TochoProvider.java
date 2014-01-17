package calculotochos.data;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.constraints.UniqueFieldValueConstraintViolationException;
import com.db4o.ext.DatabaseClosedException;
import com.db4o.ext.DatabaseFileLockedException;
import com.db4o.ext.DatabaseReadOnlyException;
import com.db4o.ext.Db4oIOException;
import com.db4o.ext.IncompatibleFileFormatException;
import com.db4o.ext.OldFormatException;

/**
 *
 * @author Maxi
 */
public class TochoProvider {
    ObjectContainer db = null;

    /**
     *
     * @throws DatabaseFileLockedException
     * @throws DatabaseReadOnlyException
     * @throws Db4oIOException
     * @throws IncompatibleFileFormatException
     * @throws OldFormatException
     */
    public TochoProvider() throws DatabaseFileLockedException, DatabaseReadOnlyException,
            Db4oIOException, IncompatibleFileFormatException, OldFormatException {
        this.db = new DataProvider().getDB();
    }

    public void add(Tocho data) throws DatabaseClosedException, DatabaseReadOnlyException {
        db.store(data);
    }

    public void update(Tocho data) throws DatabaseClosedException, DatabaseReadOnlyException {
        db.store(data);
    }

    public void delete(Tocho data) throws DatabaseClosedException, DatabaseReadOnlyException, Db4oIOException {
        db.delete(data);
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

    public ObjectSet<Tocho> getAll() throws DatabaseClosedException, Db4oIOException {
        return db.queryByExample(Tocho.class);
    }

}
