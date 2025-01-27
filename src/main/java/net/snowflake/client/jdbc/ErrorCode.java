/*
 * Copyright (c) 2012-2019 Snowflake Computing Inc. All rights reserved.
 */

package net.snowflake.client.jdbc;

import net.snowflake.common.core.SqlState;

/**
 * Internal JDBC driver error codes
 *
 * @author jhuang
 */
public enum ErrorCode {

  /**
   * Error codes partitioning:
   *
   * <p>0NNNNN: GS SQL error codes 1NNNNN: XP error codes 2NNNNN: JDBC driver error codes 3NNNNN: GS
   * generic error codes 4NNNNN: Node.js driver error codes
   *
   * <p>N can be any digits from 0 to 9.
   */
  INTERNAL_ERROR(200001, SqlState.INTERNAL_ERROR),
  CONNECTION_ERROR(200002, SqlState.SQLCLIENT_UNABLE_TO_ESTABLISH_SQLCONNECTION),
  INTERRUPTED(200003, SqlState.QUERY_CANCELED),
  COMPRESSION_TYPE_NOT_SUPPORTED(200004, SqlState.FEATURE_NOT_SUPPORTED),
  QUERY_CANCELED(200005, SqlState.QUERY_CANCELED),
  COMPRESSION_TYPE_NOT_KNOWN(200006, SqlState.FEATURE_NOT_SUPPORTED),
  FAIL_LIST_FILES(200007, SqlState.DATA_EXCEPTION),
  FILE_NOT_FOUND(200008, SqlState.DATA_EXCEPTION),
  FILE_IS_DIRECTORY(200009, SqlState.DATA_EXCEPTION),
  DUPLICATE_CONNECTION_PROPERTY_SPECIFIED(200010, SqlState.DATA_EXCEPTION),
  MISSING_USERNAME(200011, SqlState.INVALID_AUTHORIZATION_SPECIFICATION),
  MISSING_PASSWORD(200012, SqlState.INVALID_AUTHORIZATION_SPECIFICATION),
  S3_OPERATION_ERROR(200013, SqlState.SYSTEM_ERROR),
  MAX_RESULT_LIMIT_EXCEEDED(200014, SqlState.PROGRAM_LIMIT_EXCEEDED),
  NETWORK_ERROR(200015, SqlState.IO_ERROR),
  IO_ERROR(200016, SqlState.IO_ERROR),
  PATH_NOT_DIRECTORY(200017, SqlState.DATA_EXCEPTION),
  DATA_TYPE_NOT_SUPPORTED(200018, SqlState.FEATURE_NOT_SUPPORTED),
  CLIENT_SIDE_SORTING_NOT_SUPPORTED(200019, SqlState.FEATURE_NOT_SUPPORTED),
  AWS_CLIENT_ERROR(200020, SqlState.SYSTEM_ERROR),
  INVALID_SQL(200021, SqlState.SQL_STATEMENT_NOT_YET_COMPLETE),
  BAD_RESPONSE(200022, SqlState.INTERNAL_ERROR),
  ARRAY_BIND_MIXED_TYPES_NOT_SUPPORTED(200023, SqlState.FEATURE_NOT_SUPPORTED),
  STATEMENT_CLOSED(200024, SqlState.FEATURE_NOT_SUPPORTED),
  STATEMENT_ALREADY_RUNNING_QUERY(200025, SqlState.FEATURE_NOT_SUPPORTED),
  MISSING_SERVER_URL(200026, SqlState.INVALID_AUTHORIZATION_SPECIFICATION),
  TOO_MANY_SESSION_PARAMETERS(200027, SqlState.FEATURE_NOT_SUPPORTED),
  MISSING_CONNECTION_PROPERTY(200028, SqlState.INVALID_AUTHORIZATION_SPECIFICATION),
  INVALID_CONNECTION_URL(200029, SqlState.INVALID_AUTHORIZATION_SPECIFICATION),
  DUPLICATE_STATEMENT_PARAMETER_SPECIFIED(200030, SqlState.DATA_EXCEPTION),
  TOO_MANY_STATEMENT_PARAMETERS(200031, SqlState.FEATURE_NOT_SUPPORTED),
  COLUMN_DOES_NOT_EXIST(200032, SqlState.DATA_EXCEPTION),
  INVALID_PARAMETER_TYPE(200033, SqlState.INVALID_PARAMETER_VALUE),
  ROW_DOES_NOT_EXIST(200034, SqlState.DATA_EXCEPTION),
  FEATURE_UNSUPPORTED(200035, SqlState.FEATURE_NOT_SUPPORTED),
  INVALID_STATE(200036, SqlState.FEATURE_NOT_SUPPORTED),
  RESULTSET_ALREADY_CLOSED(200037, SqlState.FEATURE_NOT_SUPPORTED),
  INVALID_VALUE_CONVERT(200038, SqlState.FEATURE_NOT_SUPPORTED),
  IDP_CONNECTION_ERROR(200039, SqlState.SQLCLIENT_UNABLE_TO_ESTABLISH_SQLCONNECTION),
  IDP_INCORRECT_DESTINATION(200040, SqlState.SQLCLIENT_UNABLE_TO_ESTABLISH_SQLCONNECTION),
  CONNECTION_ESTABLISHED_WITH_DIFFERENT_PROP(200041, SqlState.WARNING),
  UNSUPPORTED_STATEMENT_TYPE_IN_EXECUTION_API(200042, SqlState.FEATURE_NOT_SUPPORTED),
  STATEMENT_PREPARE_FAILURE(200043, SqlState.FEATURE_NOT_SUPPORTED),
  AZURE_SERVICE_ERROR(200044, SqlState.SYSTEM_ERROR),

  INVALID_OR_UNSUPPORTED_PRIVATE_KEY(200045, SqlState.SYNTAX_ERROR),
  FAILED_TO_GENERATE_JWT(200046, SqlState.SYNTAX_ERROR),
  INVALID_PARAMETER_VALUE(200047, SqlState.INVALID_PARAMETER_VALUE),
  QUERY_FIRST_RESULT_NOT_RESULT_SET(200048, SqlState.WARNING),
  UPDATE_FIRST_RESULT_NOT_UPDATE_COUNT(200049, SqlState.WARNING),
  CHILD_RESULT_IDS_AND_TYPES_DIFFERENT_SIZES(200050, SqlState.INTERNAL_ERROR),
  INVALID_PROXY_PROPERTIES(200051, SqlState.CONNECTION_EXCEPTION),
  CONNECTION_CLOSED(200052, SqlState.CONNECTION_DOES_NOT_EXIST),
  NON_FATAL_ERROR(200053, SqlState.WARNING),
  NUMERIC_VALUE_OUT_OF_RANGE(200054, SqlState.NUMERIC_VALUE_OUT_OF_RANGE),
  NO_VALID_DATA(200055, SqlState.NO_DATA),
  INVALID_APP_NAME(200056, SqlState.INVALID_PARAMETER_VALUE),
  EXECUTE_BATCH_INTEGER_OVERFLOW(200058, SqlState.NUMERIC_VALUE_OUT_OF_RANGE),
  INVALID_CONNECT_STRING(200059, SqlState.CONNECTION_EXCEPTION),
  INVALID_OKTA_USERNAME(200060, SqlState.CONNECTION_EXCEPTION),
  GCP_SERVICE_ERROR(200061, SqlState.SYSTEM_ERROR),
  AUTHENTICATOR_REQUEST_TIMEOUT(200062, SqlState.CONNECTION_EXCEPTION),
  INVALID_STRUCT_DATA(200063, SqlState.DATA_EXCEPTION),
  DISABLEOCSP_INSECUREMODE_VALUE_MISMATCH(200064, SqlState.INVALID_PARAMETER_VALUE),
  TOO_MANY_FILES_TO_DOWNLOAD_AS_STREAM(200065, SqlState.DATA_EXCEPTION);

  public static final String errorMessageResource = "net.snowflake.client.jdbc.jdbc_error_messages";

  /** Snowflake internal message associated to the error. */
  private final Integer messageCode;

  private final String sqlState;

  /**
   * Construct a new error code specification given Snowflake internal error code and SQL state
   * error code.
   *
   * <p>
   *
   * @param messageCode Snowflake internal error code
   * @param sqlState SQL state error code
   */
  ErrorCode(Integer messageCode, String sqlState) {
    this.messageCode = messageCode;
    this.sqlState = sqlState;
  }

  public Integer getMessageCode() {
    return messageCode;
  }

  public String getSqlState() {
    return sqlState;
  }

  @Override
  public String toString() {
    return "ErrorCode{" + "messageCode=" + messageCode + ", sqlState=" + sqlState + '}';
  }
}
