package fr.univnantes.bidirectional.generics;

import fr.univnantes.bidirectional.generics.OneToMany.GenericFiles;
import fr.univnantes.bidirectional.generics.OneToMany.GenericFolder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class OneToManyTest {
    private GenericFolder folder1, folder2;
    private GenericFiles file1, file2, file3;

    @BeforeEach
    void setup() {
        folder1 = new GenericFolder();
        folder2 = new GenericFolder();

        file1 = new GenericFiles();
        file2 = new GenericFiles();
        file3 = new GenericFiles();
    }

    @Test
    void setFolderTest() {
        file1.setFolder(folder1);
        assertTrue(file1.getReference().isSet());
        assertFalse(folder1.getFiles().isEmpty());
        assertSame(folder1, file1.getFolder());
        assertSame(file1, folder1.getFiles().get(0));
        assertEquals(1, folder1.getFiles().size());

        file1.setFolder(folder2);
        assertTrue(file1.getReference().isSet());
        assertFalse(folder2.getFiles().isEmpty());
        assertTrue(folder1.getFiles().isEmpty());
        assertEquals(1, folder2.getFiles().size());
        assertSame(folder2, file1.getFolder());
        assertSame(file1, folder2.getFiles().get(0));
    }

    @Test
    void setFolderManyTimesTest() {
        file1.setFolder(folder1);
        file1.setFolder(folder1);
        assertTrue(file1.getReference().isSet());
        assertFalse(folder1.getFiles().isEmpty());
        assertSame(folder1, file1.getFolder());
        assertSame(file1, folder1.getFiles().get(0));
        assertEquals(1, folder1.getFiles().size());
    }

    @Test
    void setFolderWithManyFilesTest() {
        file1.setFolder(folder1);
        file2.setFolder(folder1);
        file3.setFolder(folder1);

        assertTrue(file1.getReference().isSet());
        assertTrue(file2.getReference().isSet());
        assertTrue(file3.getReference().isSet());
        assertFalse(folder1.getFiles().isEmpty());
        assertEquals(3, folder1.getFiles().size());
        assertSame(folder1, file1.getFolder());
        assertSame(folder1, file2.getFolder());
        assertSame(folder1, file3.getFolder());

        assertSame(file1, folder1.getFiles().get(0)); //Depends on the type of List used.
        assertSame(file2, folder1.getFiles().get(1));
        assertSame(file3, folder1.getFiles().get(2));
    }

    @Test
    void addFileTest() {
        folder1.addFile(file1);

        assertTrue(file1.getReference().isSet());
        assertFalse(folder1.getFiles().isEmpty());
        assertSame(folder1, file1.getFolder());
        assertSame(file1, folder1.getFiles().get(0));
        assertEquals(1, folder1.getFiles().size());
    }

    @Test
    void addFileManyTimesTest() {
        folder1.addFile(file1);
        folder1.addFile(file1);
        folder1.addFile(file1);

        assertTrue(file1.getReference().isSet());
        assertFalse(folder1.getFiles().isEmpty());
        assertSame(folder1, file1.getFolder());
        assertSame(file1, folder1.getFiles().get(0));
        assertEquals(1, folder1.getFiles().size());
    }

    @Test
    void addManyFilesTest() {
        folder1.addFile(file1);
        folder1.addFile(file2);
        folder1.addFile(file3);

        assertTrue(file1.getReference().isSet());
        assertTrue(file2.getReference().isSet());
        assertTrue(file3.getReference().isSet());
        assertFalse(folder1.getFiles().isEmpty());
        assertEquals(3, folder1.getFiles().size());
        assertSame(folder1, file1.getFolder());
        assertSame(folder1, file2.getFolder());
        assertSame(folder1, file3.getFolder());

        assertSame(file1, folder1.getFiles().get(0)); //Depends on the type of List used ?
        assertSame(file2, folder1.getFiles().get(1));
        assertSame(file3, folder1.getFiles().get(2));
    }

    @Test
    void removeFolderTest() {
        file1.setFolder(folder1);
        file1.unsetFolder();

        assertFalse(file1.getReference().isSet());
        assertTrue(folder1.getFiles().isEmpty());
        assertEquals(0, folder1.getFiles().size());
    }

    @Test
    void removeFileTest() {
        folder2.addFile(file1);
        folder2.removeFile(file1);

        assertFalse(file1.getReference().isSet());
        assertTrue(folder2.getFiles().isEmpty());
        assertEquals(0, folder2.getFiles().size());
    }

    @Test
    void removeManyFilesTest() {
        folder1.addFile(file1);
        folder1.addFile(file2);
        folder1.addFile(file3);

        folder1.removeFile(file1);

        assertFalse(file1.getReference().isSet());
        assertTrue(file2.getReference().isSet());
        assertTrue(file3.getReference().isSet());
        assertEquals(2, folder1.getFiles().size());
        assertFalse(folder1.getFiles().contains(file1));
        assertTrue(folder1.getFiles().contains(file2));
        assertTrue(folder1.getFiles().contains(file3));

        folder1.removeFile(file2);

        assertFalse(file1.getReference().isSet());
        assertFalse(file2.getReference().isSet());
        assertTrue(file3.getReference().isSet());
        assertEquals(1, folder1.getFiles().size());
        assertFalse(folder1.getFiles().contains(file1));
        assertFalse(folder1.getFiles().contains(file2));
        assertTrue(folder1.getFiles().contains(file3));

        folder1.removeFile(file3);

        assertFalse(file1.getReference().isSet());
        assertFalse(file2.getReference().isSet());
        assertFalse(file3.getReference().isSet());
        assertEquals(0, folder1.getFiles().size());
        assertFalse(folder1.getFiles().contains(file1));
        assertFalse(folder1.getFiles().contains(file2));
        assertFalse(folder1.getFiles().contains(file3));
    }
}
