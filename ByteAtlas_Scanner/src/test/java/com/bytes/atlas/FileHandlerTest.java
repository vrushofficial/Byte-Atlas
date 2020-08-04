package com.bytes.atlas;

import com.bytes.atlas.domain.FileHandler;
import com.bytes.atlas.model.Project;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FileHandlerTest {

   private Project project;

   public FileHandlerTest(Project p) {
      this.project = p;
   }

   @Parameters
   public static Collection<?> params() {
      Project project = new Project();
      project.setSourcePath("TestData");
      project.setProjectKey("TestData");
      return Arrays.asList(new Object[]{project});
   }

   @Test
   public void testReadFiles() {
      new FileHandler().readFiles(project);
      int expected = 2;
      int actual = project.getFiles().size();
      assertEquals(expected, actual);
   }

}
