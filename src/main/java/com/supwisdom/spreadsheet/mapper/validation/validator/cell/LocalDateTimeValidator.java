package com.supwisdom.spreadsheet.mapper.validation.validator.cell;

import com.supwisdom.spreadsheet.mapper.model.core.Cell;
import com.supwisdom.spreadsheet.mapper.model.meta.FieldMeta;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * local date time validator
 * <p>
 * Created by hanwen on 2017/1/11.
 */
public class LocalDateTimeValidator extends CustomSingleCellValidatorAdapter<LocalDateTimeValidator> {

  private static final Logger LOGGER = LoggerFactory.getLogger(LocalDateTimeValidator.class);

  private String pattern;

  public LocalDateTimeValidator pattern(String pattern) {
    this.pattern = pattern;
    return this;
  }

  @Override
  protected boolean customValid(Cell cell, FieldMeta fieldMeta) {
    DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(pattern);
    String value = cell.getValue();

    try {
      dateTimeFormatter.parseLocalDateTime(value);
    } catch (IllegalArgumentException e) {
      LOGGER.debug("{} format not valid", value);
      return false;
    }
    return true;
  }

}