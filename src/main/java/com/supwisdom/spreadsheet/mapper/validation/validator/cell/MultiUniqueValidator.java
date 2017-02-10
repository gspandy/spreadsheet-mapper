package com.supwisdom.spreadsheet.mapper.validation.validator.cell;

import org.apache.commons.lang3.StringUtils;
import com.supwisdom.spreadsheet.mapper.model.core.Cell;
import com.supwisdom.spreadsheet.mapper.model.meta.FieldMeta;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <pre>
 * value union unique validator, it useful when you want validate some cells value union unique.
 *
 * eg:
 * if you excel files has person.idCardNumber and person.idCardType, you will want check if person's identify unique,
 * when the excel files has duplicate person identify this validator will get false.
 * </pre>
 * Created by hanwen on 2016/12/1.
 */
public class MultiUniqueValidator extends CustomMultiCellValidator<MultiUniqueValidator> {

  // format: "field1:value1,field2:value2,..."
  private Set<String> rowValueHolder = new HashSet<>();

  @Override
  protected boolean doValidate(List<Cell> cells, List<FieldMeta> fieldMetas) {

    List<String> holdStringList = new ArrayList<>();

    for (int i = 0; i < cells.size(); i++) {
      holdStringList.add(buildHoldString(fieldMetas.get(i), cells.get(i)));
    }

    String holdValue = StringUtils.join(holdStringList, ",");

    if (rowValueHolder.contains(holdValue)) {
      return false;
    }

    rowValueHolder.add(holdValue);
    return true;
  }

  /**
   * build cache string as "field:value"
   *
   * @param fieldMeta {@link FieldMeta}
   * @param cell      {@link Cell}
   * @return hold string
   */
  private String buildHoldString(FieldMeta fieldMeta, Cell cell) {
    return fieldMeta.getName() + ":" + cell.getValue();
  }
}
