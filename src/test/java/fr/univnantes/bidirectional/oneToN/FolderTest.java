package fr.univnantes.bidirectional.oneToN;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class FolderTest {

    private Folder myFolder;
    private File file1, file2, file3;

    @BeforeEach
    void setup() {
        myFolder = new Folder("myFolder");

        file1 = new File("file1", 10);
        file2 = new File("file2", 15);
        file3 = new File("file3", 20);
    }

    @Test
    void addFileTest() {
        myFolder.addFile(file1);
        assertTrue(myFolder.getFiles().getFiles().contains(file1));
        assertSame(file1.getFolder().getFolder(), myFolder);
    }

    @Test
    void addManyFilesTest() {
        myFolder.addFile(file1);
        myFolder.addFile(file2);
        myFolder.addFile(file3);

        assertTrue(myFolder.getFiles().getFiles().contains(file1));
        assertTrue(myFolder.getFiles().getFiles().contains(file2));
        assertTrue(myFolder.getFiles().getFiles().contains(file3));

        assertEquals(3, myFolder.getFiles().getFiles().size());

        assertSame(file1.getFolder().getFolder(), myFolder);
        assertSame(file2.getFolder().getFolder(), myFolder);
        assertSame(file3.getFolder().getFolder(), myFolder);
    }

    @Test
    void removeFileTest() {
        myFolder.addFile(file1);
        myFolder.removeFile(file1);

        assertFalse(myFolder.getFiles().getFiles().contains(file1));
        assertTrue(myFolder.getFiles().getFiles().isEmpty());
    }

    @Test
    void removeManyFilesTest() {
        myFolder.addFile(file1);
        myFolder.addFile(file2);
        myFolder.addFile(file3);

        myFolder.removeFile(file1);

        assertEquals(2, myFolder.getFiles().getFiles().size());
        assertTrue(myFolder.getFiles().getFiles().contains(file2));
        assertTrue(myFolder.getFiles().getFiles().contains(file3));

        myFolder.removeFile(file2);

        assertEquals(1, myFolder.getFiles().getFiles().size());
        assertTrue(myFolder.getFiles().getFiles().contains(file3));

        myFolder.removeFile(file3);

        assertTrue(myFolder.getFiles().getFiles().isEmpty());
    }


}
