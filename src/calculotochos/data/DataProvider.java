package calculotochos.data;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.constraints.UniqueFieldValueConstraint;
import com.db4o.ext.DatabaseFileLockedException;
import com.db4o.ext.DatabaseReadOnlyException;
import com.db4o.ext.Db4oIOException;
import com.db4o.ext.IncompatibleFileFormatException;
import com.db4o.ext.OldFormatException;

/**
 *
 * @author Maxi
 */
public class DataProvider {

    private ObjectContainer db = null;

    /**
     *
     * @throws Db4oIOException
     * @throws DatabaseFileLockedException
     * @throws IncompatibleFileFormatException
     * @throws OldFormatException
     * @throws DatabaseReadOnlyException
     */
    public DataProvider() throws Db4oIOException, DatabaseFileLockedException,
            IncompatibleFileFormatException, OldFormatException, DatabaseReadOnlyException {
        EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
        config.common().add(new UniqueFieldValueConstraint(Perfil.class, "id"));
        db = Db4oEmbedded.openFile(config, "calculotochos.db4o");
    }

    public ObjectContainer getDB() {
        return this.db;
    }
    
    public void closeDB(){
        if(db != null){
            db.close();
        }
    }
}
