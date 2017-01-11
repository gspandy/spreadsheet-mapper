package spreadsheet.mapper.f2w.read;

import org.testng.annotations.Test;
import spreadsheet.mapper.AssertUtil;
import spreadsheet.mapper.model.core.Workbook;

import java.io.InputStream;

import static org.testng.Assert.assertEquals;

/**
 * Created by hanwen on 2017/1/5.
 */
@Test(groups = "Excel2WorkbookReaderTest")
public class Excel2WorkbookReaderTest {

  @Test
  public void testRead() throws Exception {

    InputStream is1 = getClass().getResourceAsStream("test.xls");

    WorkbookReader reader = new Excel2WorkbookReader();

    Workbook workbook1 = reader.read(is1);

    AssertUtil.assertWorkbookEquals(workbook1, true);

    InputStream is2 = getClass().getResourceAsStream("test.xlsx");

    Workbook workbook2 = reader.read(is2);

    AssertUtil.assertWorkbookEquals(workbook2, true);
  }
}