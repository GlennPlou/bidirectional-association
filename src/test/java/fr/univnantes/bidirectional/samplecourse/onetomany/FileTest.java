package fr.univnantes.bidirectional.samplecourse.onetomany;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

/**
 * Test class to check the proper functionality of the File class, and the association File --> Folder.
 *
 * @author Glenn Plouhinec
 * @version 0.1
 */
class FileTest {

    private Folder principalFolder, secondFolder;
    private File myFile;

    /**
     * Initializes the file and folders.
     */
    @BeforeEach
    void setup() {
        principalFolder = new Folder("principalFolder");
        secondFolder = new Folder("secondFolder");

        myFile = new File("myFile", 15);
    }

    /**
     * Checks that the folder reference is set up correctly.
     */
    @Test
    void setFolderTest() {
        myFile.setFolder(principalFolder);
        assertSame(myFile.getFolder().getFolder(), principalFolder);
        assertTrue(principalFolder.getFiles().getFiles().contains(myFile));

        myFile.setFolder(secondFolder);
        assertSame(myFile.getFolder().getFolder(), secondFolder);
        assertTrue(secondFolder.getFiles().getFiles().contains(myFile));
        assertTrue(principalFolder.getFiles().getFiles().isEmpty());
    }

    /**
     * Checks that the folder reference is removed correctly.
     */
    @Test
    void unsetFolderTest() {
        myFile.setFolder(principalFolder);
        myFile.unsetFolder();
        assertFalse(myFile.getFolder().isSet());
        assertTrue(principalFolder.getFiles().getFiles().isEmpty());
    }
}
