package com.supwisdom.spreadsheet.mapper.validation.validator.sheet;

import com.supwisdom.spreadsheet.mapper.model.core.Sheet;
import com.supwisdom.spreadsheet.mapper.model.meta.SheetMeta;

/**
 * sheet validator, after workbook validators, if workbook validators failure, sheet validators will skip.
 * <p>
 * Created by hanwen on 2016/12/23.
 */
public interface SheetValidator {

  /**
   * the error message will be collected when validator failure if error message is not blank
   *
   * @return validate error message
   */
  String getErrorMessage();

  /**
   * validate supplied sheet
   *
   * @param sheet     {@link Sheet}
   * @param sheetMeta {@link SheetMeta}
   * @return true if pass
   */
  boolean valid(Sheet sheet, SheetMeta sheetMeta);
}
