package spreadsheet.mapper.w2o.validator;

import java.util.Set;

/**
 * dependency validator, after workbook and sheet validators, if post validators failure, dependency validators will skip.
 * <p>
 * Created by hanwen on 2016/12/26.
 */
public interface DependencyValidator extends Validator {

  /**
   * the validator group name
   *
   * @return the group name
   */
  String getGroup();

  /**
   * <pre>
   * the validator do valid after depends on group validators.
   * the group validators sequence is the sequence of add to validate engine.
   * notice:
   * 1. all depends on groups valid passed will do this validator.
   * 2. if in the same groups one valid failure the rest validators of this group will skip.
   * 3. if siblings groups, one group failure, others siblings groups if do valid depends on the sequence of depends on groups you add,
   *    if the failure group add first, other siblings groups will skip, else other siblings group will do valid.
   * </pre>
   *
   * @return depends on groups
   */
  Set<String> getDependsOn();
}
