package fr.univnantes.bidirectional.oneToN;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

class FileTest {

    private Folder principalFolder, secondFolder;
    private File myFile;

    @BeforeEach
    void setup() {
        principalFolder = new Folder("principalFolder");
        secondFolder = new Folder("secondFolder");

        myFile = new File("myFile", 15);
    }

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

    @Test
    void removeFolderTest() {
        myFile.setFolder(principalFolder);
        myFile.removeFolder();
        assertFalse(myFile.getFolder().isSet());
        assertTrue(principalFolder.getFiles().getFiles().isEmpty());
    }
}
