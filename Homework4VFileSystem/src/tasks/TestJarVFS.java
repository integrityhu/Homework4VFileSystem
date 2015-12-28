/**
 * 
 */
package tasks;

import org.apache.commons.vfs.FileObject;
import org.apache.commons.vfs.FileSystemException;
import org.apache.commons.vfs.FileSystemManager;
import org.apache.commons.vfs.VFS;

/**
 * @author pzoli
 * http://commons.apache.org/proper/commons-vfs/filesystems.htm
 * 
 */
public class TestJarVFS {

    public static void listFiles(String fileName) throws FileSystemException {
        FileSystemManager fsManager = VFS.getManager();
        
        FileObject jarFile = fsManager.resolveFile( "jar:file:///"+fileName );

        // List the children of the Jar file
        FileObject[] children = jarFile.getChildren();
        System.out.println( "Children of " + jarFile.getName().getURI() );
        for ( int i = 0; i < children.length; i++ )
        {
            System.out.println( children[ i ].getName().getBaseName() );
        }
        
        
    }
}
