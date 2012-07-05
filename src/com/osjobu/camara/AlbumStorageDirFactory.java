package com.osjobu.camara;

/**
 * Created with IntelliJ IDEA.
 * User: Oscar
 * Date: 5/07/12
 * Time: 12:59 PM
 * To change this template use File | Settings | File Templates.
 */
import java.io.File;

abstract class AlbumStorageDirFactory {
    public abstract File getAlbumStorageDir(String albumName);
}
