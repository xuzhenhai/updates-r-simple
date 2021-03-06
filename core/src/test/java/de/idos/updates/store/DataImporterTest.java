package de.idos.updates.store;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.ByteArrayInputStream;

import static org.mockito.Mockito.*;

public class DataImporterTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void closesStreamAfterOperation() throws Exception {
        ByteArrayInputStream stream = spy(new ByteArrayInputStream("Hallo".getBytes()));
        InputStreamFactory factory = mock(InputStreamFactory.class);
        when(factory.openStream()).thenReturn(stream);
        new DataImporter(factory).importTo(folder.getRoot(), "Test");
        verify(stream).close();
    }
}
