package com.quartz.system.core;

import org.quartz.impl.jdbcjobstore.Constants;

/**
 * @packageName：com.quartz.system.core
 * @desrciption: 复写sql操作常量
 * @author: gaowei
 * @date： 2018-11-29 13:28
 * @history: (version) author date desc
 */
public interface QuartzJDBCConstants extends Constants {

/*
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *
     * Constants.
     *
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */

    // table prefix substitution string
    String TABLE_PREFIX_SUBST = "{0}";
    /**
     * 添加任务唯一标识 ，一般为当前工程名
     */
    String SYSTEM_NAME_CONDITION = "SYSTEM_NAME={1} ";

    //system flag
    String COL_SYSTEM_NAME = "SYSTEM_NAME";

    // QUERIES
    String UPDATE_TRIGGER_STATES_FROM_OTHER_STATES = "UPDATE "
            + TABLE_PREFIX_SUBST
            + TABLE_TRIGGERS
            + " SET "
            + COL_TRIGGER_STATE
            + " = ?"
            + " WHERE ("
            + COL_TRIGGER_STATE
            + " = ? OR "
            + COL_TRIGGER_STATE + " = ? ) AND " + SYSTEM_NAME_CONDITION;

    String UPDATE_TRIGGER_STATE_FROM_OTHER_STATES_BEFORE_TIME = "UPDATE "
            + TABLE_PREFIX_SUBST
            + TABLE_TRIGGERS
            + " SET "
            + COL_TRIGGER_STATE
            + " = ?"
            + " WHERE ("
            + COL_TRIGGER_STATE
            + " = ? OR "
            + COL_TRIGGER_STATE + " = ?) AND " + COL_NEXT_FIRE_TIME + " < ? AND " + SYSTEM_NAME_CONDITION;

    String SELECT_MISFIRED_TRIGGERS = "SELECT * FROM "
            + TABLE_PREFIX_SUBST + TABLE_TRIGGERS + " WHERE "
            + COL_NEXT_FIRE_TIME + " < ? AND " + SYSTEM_NAME_CONDITION
            + "ORDER BY "+ COL_NEXT_FIRE_TIME + " ASC, " + COL_PRIORITY + " DESC";

    String SELECT_TRIGGERS_IN_STATE = "SELECT "
            + COL_TRIGGER_NAME + ", " + COL_TRIGGER_GROUP + " FROM "
            + TABLE_PREFIX_SUBST + TABLE_TRIGGERS + " WHERE "
            + COL_TRIGGER_STATE + " = ? AND " + SYSTEM_NAME_CONDITION;

    String SELECT_MISFIRED_TRIGGERS_IN_STATE = "SELECT "
            + COL_TRIGGER_NAME + ", " + COL_TRIGGER_GROUP + " FROM "
            + TABLE_PREFIX_SUBST + TABLE_TRIGGERS + " WHERE "
            + COL_NEXT_FIRE_TIME + " < ? AND " + COL_TRIGGER_STATE + " = ? AND " + SYSTEM_NAME_CONDITION
            + "ORDER BY "+ COL_NEXT_FIRE_TIME + " ASC, " + COL_PRIORITY + " DESC";

    String COUNT_MISFIRED_TRIGGERS_IN_STATES = "SELECT COUNT("
            + COL_TRIGGER_NAME + ") FROM "
            + TABLE_PREFIX_SUBST + TABLE_TRIGGERS + " WHERE "
            + COL_NEXT_FIRE_TIME + " < ? "
            + "AND ((" + COL_TRIGGER_STATE + " = ?) OR (" + COL_TRIGGER_STATE + " = ?)) AND " + SYSTEM_NAME_CONDITION;

    String SELECT_MISFIRED_TRIGGERS_IN_STATES = "SELECT "
            + COL_TRIGGER_NAME + ", " + COL_TRIGGER_GROUP + " FROM "
            + TABLE_PREFIX_SUBST + TABLE_TRIGGERS + " WHERE "
            + COL_NEXT_FIRE_TIME + " < ? "
            + "AND ((" + COL_TRIGGER_STATE + " = ?) OR (" + COL_TRIGGER_STATE + " = ?)) AND " + SYSTEM_NAME_CONDITION
            + "ORDER BY "+ COL_NEXT_FIRE_TIME + " ASC, " + COL_PRIORITY + " DESC";

    String SELECT_MISFIRED_TRIGGERS_IN_GROUP_IN_STATE = "SELECT "
            + COL_TRIGGER_NAME
            + " FROM "
            + TABLE_PREFIX_SUBST
            + TABLE_TRIGGERS
            + " WHERE "
            + COL_NEXT_FIRE_TIME
            + " < ? AND "
            + COL_TRIGGER_GROUP
            + " = ? AND " + COL_TRIGGER_STATE + " = ? AND " + SYSTEM_NAME_CONDITION
            + "ORDER BY "+ COL_NEXT_FIRE_TIME + " ASC, " + COL_PRIORITY + " DESC";


    String SELECT_VOLATILE_TRIGGERS = "SELECT "
            + COL_TRIGGER_NAME + ", " + COL_TRIGGER_GROUP + " FROM "
            + TABLE_PREFIX_SUBST + TABLE_TRIGGERS + " WHERE " + COL_IS_VOLATILE
            + " = ? AND " + SYSTEM_NAME_CONDITION;

    String DELETE_FIRED_TRIGGERS = "DELETE FROM "
            + TABLE_PREFIX_SUBST + TABLE_FIRED_TRIGGERS + " WHERE " + SYSTEM_NAME_CONDITION;

    String INSERT_JOB_DETAIL = "INSERT INTO "
            + TABLE_PREFIX_SUBST + TABLE_JOB_DETAILS + " (" + COL_JOB_NAME
            + ", " + COL_JOB_GROUP + ", " + COL_DESCRIPTION + ", "
            + COL_JOB_CLASS + ", " + COL_IS_DURABLE + ", " + COL_IS_VOLATILE
            + ", " + COL_IS_STATEFUL + ", " + COL_REQUESTS_RECOVERY + ", "
            + COL_JOB_DATAMAP + ",  " + COL_SYSTEM_NAME + ") " + " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, {1})";

    String UPDATE_JOB_DETAIL = "UPDATE "
            + TABLE_PREFIX_SUBST + TABLE_JOB_DETAILS + " SET "
            + COL_DESCRIPTION + " = ?, " + COL_JOB_CLASS + " = ?, "
            + COL_IS_DURABLE + " = ?, " + COL_IS_VOLATILE + " = ?, "
            + COL_IS_STATEFUL + " = ?, " + COL_REQUESTS_RECOVERY + " = ?, "
            + COL_JOB_DATAMAP + " = ? " + " WHERE " + COL_JOB_NAME
            + " = ? AND " + COL_JOB_GROUP + " = ? AND " + SYSTEM_NAME_CONDITION;

    String SELECT_TRIGGERS_FOR_JOB = "SELECT "
            + COL_TRIGGER_NAME + ", " + COL_TRIGGER_GROUP + " FROM "
            + TABLE_PREFIX_SUBST + TABLE_TRIGGERS + " WHERE " + COL_JOB_NAME
            + " = ? AND " + COL_JOB_GROUP + " = ? AND " + SYSTEM_NAME_CONDITION;

    String SELECT_TRIGGERS_FOR_CALENDAR = "SELECT "
            + COL_TRIGGER_NAME + ", " + COL_TRIGGER_GROUP + " FROM "
            + TABLE_PREFIX_SUBST + TABLE_TRIGGERS + " WHERE " + COL_CALENDAR_NAME
            + " = ? AND " + SYSTEM_NAME_CONDITION;

    //.TODO
    String SELECT_STATEFUL_JOBS_OF_TRIGGER_GROUP = "SELECT DISTINCT J."
            + COL_JOB_NAME
            + ", J."
            + COL_JOB_GROUP
            + " FROM "
            + TABLE_PREFIX_SUBST
            + TABLE_TRIGGERS
            + " T, "
            + TABLE_PREFIX_SUBST
            + TABLE_JOB_DETAILS
            + " J WHERE T."
            + COL_TRIGGER_GROUP
            + " = ? AND T."
            + COL_JOB_NAME
            + " = J."
            + COL_JOB_NAME
            + " AND T."
            + COL_JOB_GROUP
            + " = J."
            + COL_JOB_GROUP
            + " AND J."
            + COL_IS_STATEFUL + " = ? " + " AND T." + COL_SYSTEM_NAME + " = J." + COL_SYSTEM_NAME + " AND T." + SYSTEM_NAME_CONDITION;

    String DELETE_JOB_LISTENERS = "DELETE FROM "
            + TABLE_PREFIX_SUBST + TABLE_JOB_LISTENERS + " WHERE "
            + COL_JOB_NAME + " = ? AND " + COL_JOB_GROUP + " = ? AND " + SYSTEM_NAME_CONDITION;

    String DELETE_JOB_DETAIL = "DELETE FROM "
            + TABLE_PREFIX_SUBST + TABLE_JOB_DETAILS + " WHERE " + COL_JOB_NAME
            + " = ? AND " + COL_JOB_GROUP + " = ? AND " + SYSTEM_NAME_CONDITION;

    String SELECT_JOB_STATEFUL = "SELECT "
            + COL_IS_STATEFUL + " FROM " + TABLE_PREFIX_SUBST
            + TABLE_JOB_DETAILS + " WHERE " + COL_JOB_NAME + " = ? AND "
            + COL_JOB_GROUP + " = ? AND " + SYSTEM_NAME_CONDITION;

    String SELECT_JOB_EXISTENCE = "SELECT " + COL_JOB_NAME
            + " FROM " + TABLE_PREFIX_SUBST + TABLE_JOB_DETAILS + " WHERE "
            + COL_JOB_NAME + " = ? AND " + COL_JOB_GROUP + " = ? AND " + SYSTEM_NAME_CONDITION;

    String UPDATE_JOB_DATA = "UPDATE " + TABLE_PREFIX_SUBST
            + TABLE_JOB_DETAILS + " SET " + COL_JOB_DATAMAP + " = ? "
            + " WHERE " + COL_JOB_NAME + " = ? AND " + COL_JOB_GROUP + " = ? AND " + SYSTEM_NAME_CONDITION;

    String INSERT_JOB_LISTENER = "INSERT INTO "
            + TABLE_PREFIX_SUBST + TABLE_JOB_LISTENERS + " (" + COL_JOB_NAME
            + ", " + COL_JOB_GROUP + ", " + COL_JOB_LISTENER
            + ", " + COL_SYSTEM_NAME + ") VALUES(?, ?, ?, {1})";

    String SELECT_JOB_LISTENERS = "SELECT "
            + COL_JOB_LISTENER + " FROM " + TABLE_PREFIX_SUBST
            + TABLE_JOB_LISTENERS + " WHERE " + COL_JOB_NAME + " = ? AND "
            + COL_JOB_GROUP + " = ? AND " + SYSTEM_NAME_CONDITION;

    String SELECT_JOB_DETAIL = "SELECT *" + " FROM "
            + TABLE_PREFIX_SUBST + TABLE_JOB_DETAILS + " WHERE " + COL_JOB_NAME
            + " = ? AND " + COL_JOB_GROUP + " = ? AND " + SYSTEM_NAME_CONDITION;

    String SELECT_NUM_JOBS = "SELECT COUNT(" + COL_JOB_NAME
            + ") " + " FROM " + TABLE_PREFIX_SUBST + TABLE_JOB_DETAILS
            + " WHERE " + SYSTEM_NAME_CONDITION;

    String SELECT_JOB_GROUPS = "SELECT DISTINCT("
            + COL_JOB_GROUP + ") FROM " + TABLE_PREFIX_SUBST
            + TABLE_JOB_DETAILS + " WHERE " + SYSTEM_NAME_CONDITION;

    String SELECT_JOBS_IN_GROUP = "SELECT " + COL_JOB_NAME
            + " FROM " + TABLE_PREFIX_SUBST + TABLE_JOB_DETAILS + " WHERE "
            + COL_JOB_GROUP + " = ? AND " + SYSTEM_NAME_CONDITION;

    String SELECT_VOLATILE_JOBS = "SELECT " + COL_JOB_NAME
            + ", " + COL_JOB_GROUP + " FROM " + TABLE_PREFIX_SUBST
            + TABLE_JOB_DETAILS + " WHERE " + COL_IS_VOLATILE + " = ? AND " + SYSTEM_NAME_CONDITION;

    String INSERT_TRIGGER = "INSERT INTO "
            + TABLE_PREFIX_SUBST + TABLE_TRIGGERS + " (" + COL_TRIGGER_NAME
            + ", " + COL_TRIGGER_GROUP + ", " + COL_JOB_NAME + ", "
            + COL_JOB_GROUP + ", " + COL_IS_VOLATILE + ", " + COL_DESCRIPTION
            + ", " + COL_NEXT_FIRE_TIME + ", " + COL_PREV_FIRE_TIME + ", "
            + COL_TRIGGER_STATE + ", " + COL_TRIGGER_TYPE + ", "
            + COL_START_TIME + ", " + COL_END_TIME + ", " + COL_CALENDAR_NAME
            + ", " + COL_MISFIRE_INSTRUCTION + ", " + COL_JOB_DATAMAP + ", " + COL_PRIORITY + " , " + COL_SYSTEM_NAME + ") "
            + " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, {1})";

    String INSERT_SIMPLE_TRIGGER = "INSERT INTO "
            + TABLE_PREFIX_SUBST + TABLE_SIMPLE_TRIGGERS + " ("
            + COL_TRIGGER_NAME + ", " + COL_TRIGGER_GROUP + ", "
            + COL_REPEAT_COUNT + ", " + COL_REPEAT_INTERVAL + ", "
            + COL_TIMES_TRIGGERED + ", " + COL_SYSTEM_NAME + ") " + " VALUES(?, ?, ?, ?, ?, {1})";

    String INSERT_CRON_TRIGGER = "INSERT INTO "
            + TABLE_PREFIX_SUBST + TABLE_CRON_TRIGGERS + " ("
            + COL_TRIGGER_NAME + ", " + COL_TRIGGER_GROUP + ", "
            + COL_CRON_EXPRESSION + ", " + COL_TIME_ZONE_ID + ", " + COL_SYSTEM_NAME + ") "
            + " VALUES(?, ?, ?, ?, {1})";

    String INSERT_BLOB_TRIGGER = "INSERT INTO "
            + TABLE_PREFIX_SUBST + TABLE_BLOB_TRIGGERS + " ("
            + COL_TRIGGER_NAME + ", " + COL_TRIGGER_GROUP + ", " + COL_BLOB
            + ", " + COL_SYSTEM_NAME + ") " + " VALUES(?, ?, ?, {1})";

    String UPDATE_TRIGGER_SKIP_DATA = "UPDATE " + TABLE_PREFIX_SUBST
            + TABLE_TRIGGERS + " SET " + COL_JOB_NAME + " = ?, "
            + COL_JOB_GROUP + " = ?, " + COL_IS_VOLATILE + " = ?, "
            + COL_DESCRIPTION + " = ?, " + COL_NEXT_FIRE_TIME + " = ?, "
            + COL_PREV_FIRE_TIME + " = ?, " + COL_TRIGGER_STATE + " = ?, "
            + COL_TRIGGER_TYPE + " = ?, " + COL_START_TIME + " = ?, "
            + COL_END_TIME + " = ?, " + COL_CALENDAR_NAME + " = ?, "
            + COL_MISFIRE_INSTRUCTION + " = ?, " + COL_PRIORITY
            + " = ? WHERE " + COL_TRIGGER_NAME
            + " = ? AND " + COL_TRIGGER_GROUP + " = ? AND " + SYSTEM_NAME_CONDITION;

    String UPDATE_TRIGGER = "UPDATE " + TABLE_PREFIX_SUBST
            + TABLE_TRIGGERS + " SET " + COL_JOB_NAME + " = ?, "
            + COL_JOB_GROUP + " = ?, " + COL_IS_VOLATILE + " = ?, "
            + COL_DESCRIPTION + " = ?, " + COL_NEXT_FIRE_TIME + " = ?, "
            + COL_PREV_FIRE_TIME + " = ?, " + COL_TRIGGER_STATE + " = ?, "
            + COL_TRIGGER_TYPE + " = ?, " + COL_START_TIME + " = ?, "
            + COL_END_TIME + " = ?, " + COL_CALENDAR_NAME + " = ?, "
            + COL_MISFIRE_INSTRUCTION + " = ?, " + COL_PRIORITY + " = ?, "
            + COL_JOB_DATAMAP + " = ? WHERE "
            + COL_TRIGGER_NAME + " = ? AND " + COL_TRIGGER_GROUP + " = ? AND " + SYSTEM_NAME_CONDITION;

    String UPDATE_SIMPLE_TRIGGER = "UPDATE "
            + TABLE_PREFIX_SUBST + TABLE_SIMPLE_TRIGGERS + " SET "
            + COL_REPEAT_COUNT + " = ?, " + COL_REPEAT_INTERVAL + " = ?, "
            + COL_TIMES_TRIGGERED + " = ? WHERE " + COL_TRIGGER_NAME
            + " = ? AND " + COL_TRIGGER_GROUP + " = ? AND " + SYSTEM_NAME_CONDITION;

    String UPDATE_CRON_TRIGGER = "UPDATE "
            + TABLE_PREFIX_SUBST + TABLE_CRON_TRIGGERS + " SET "
            + COL_CRON_EXPRESSION + " = ? WHERE " + COL_TRIGGER_NAME
            + " = ? AND " + COL_TRIGGER_GROUP + " = ? AND " + SYSTEM_NAME_CONDITION;

    String UPDATE_BLOB_TRIGGER = "UPDATE "
            + TABLE_PREFIX_SUBST + TABLE_BLOB_TRIGGERS + " SET " + COL_BLOB
            + " = ? WHERE " + COL_TRIGGER_NAME + " = ? AND "
            + COL_TRIGGER_GROUP + " = ? AND " + SYSTEM_NAME_CONDITION;

    String SELECT_TRIGGER_EXISTENCE = "SELECT "
            + COL_TRIGGER_NAME + " FROM " + TABLE_PREFIX_SUBST + TABLE_TRIGGERS
            + " WHERE " + COL_TRIGGER_NAME + " = ? AND " + COL_TRIGGER_GROUP
            + " = ? AND " + SYSTEM_NAME_CONDITION;

    String UPDATE_TRIGGER_STATE = "UPDATE "
            + TABLE_PREFIX_SUBST + TABLE_TRIGGERS + " SET " + COL_TRIGGER_STATE
            + " = ?" + " WHERE " + COL_TRIGGER_NAME + " = ? AND "
            + COL_TRIGGER_GROUP + " = ? AND " + SYSTEM_NAME_CONDITION;

    String UPDATE_TRIGGER_STATE_FROM_STATE = "UPDATE "
            + TABLE_PREFIX_SUBST + TABLE_TRIGGERS + " SET " + COL_TRIGGER_STATE
            + " = ?" + " WHERE " + COL_TRIGGER_NAME + " = ? AND "
            + COL_TRIGGER_GROUP + " = ? AND " + COL_TRIGGER_STATE + " = ? AND " + SYSTEM_NAME_CONDITION;

    String UPDATE_TRIGGER_GROUP_STATE = "UPDATE "
            + TABLE_PREFIX_SUBST + TABLE_TRIGGERS + " SET " + COL_TRIGGER_STATE
            + " = ?" + " WHERE " + SYSTEM_NAME_CONDITION;

    String UPDATE_TRIGGER_GROUP_STATE_FROM_STATE = "UPDATE "
            + TABLE_PREFIX_SUBST
            + TABLE_TRIGGERS
            + " SET "
            + COL_TRIGGER_STATE
            + " = ?"
            + " WHERE "
            + COL_TRIGGER_GROUP
            + " = ? AND "
            + COL_TRIGGER_STATE + " = ? AND " + SYSTEM_NAME_CONDITION;

    String UPDATE_TRIGGER_STATE_FROM_STATES = "UPDATE "
            + TABLE_PREFIX_SUBST + TABLE_TRIGGERS + " SET " + COL_TRIGGER_STATE
            + " = ?" + " WHERE " + COL_TRIGGER_NAME + " = ? AND "
            + COL_TRIGGER_GROUP + " = ? AND (" + COL_TRIGGER_STATE + " = ? OR "
            + COL_TRIGGER_STATE + " = ? OR " + COL_TRIGGER_STATE + " = ?) AND " + SYSTEM_NAME_CONDITION;

    String UPDATE_TRIGGER_GROUP_STATE_FROM_STATES = "UPDATE "
            + TABLE_PREFIX_SUBST
            + TABLE_TRIGGERS
            + " SET "
            + COL_TRIGGER_STATE
            + " = ?"
            + " WHERE "
            + COL_TRIGGER_GROUP
            + " = ? AND ("
            + COL_TRIGGER_STATE
            + " = ? OR "
            + COL_TRIGGER_STATE
            + " = ? OR "
            + COL_TRIGGER_STATE + " = ?) AND " + SYSTEM_NAME_CONDITION;

    String UPDATE_JOB_TRIGGER_STATES = "UPDATE "
            + TABLE_PREFIX_SUBST + TABLE_TRIGGERS + " SET " + COL_TRIGGER_STATE
            + " = ? WHERE " + COL_JOB_NAME + " = ? AND " + COL_JOB_GROUP
            + " = ? AND " + SYSTEM_NAME_CONDITION;

    String UPDATE_JOB_TRIGGER_STATES_FROM_OTHER_STATE = "UPDATE "
            + TABLE_PREFIX_SUBST
            + TABLE_TRIGGERS
            + " SET "
            + COL_TRIGGER_STATE
            + " = ? WHERE "
            + COL_JOB_NAME
            + " = ? AND "
            + COL_JOB_GROUP
            + " = ? AND " + COL_TRIGGER_STATE + " = ? AND " + SYSTEM_NAME_CONDITION;

    String DELETE_TRIGGER_LISTENERS = "DELETE FROM "
            + TABLE_PREFIX_SUBST + TABLE_TRIGGER_LISTENERS + " WHERE "
            + COL_TRIGGER_NAME + " = ? AND " + COL_TRIGGER_GROUP + " = ? AND " + SYSTEM_NAME_CONDITION;

    String INSERT_TRIGGER_LISTENER = "INSERT INTO "
            + TABLE_PREFIX_SUBST + TABLE_TRIGGER_LISTENERS + " ("
            + COL_TRIGGER_NAME + ", " + COL_TRIGGER_GROUP + ", "
            + COL_TRIGGER_LISTENER + ", " + COL_SYSTEM_NAME + ") VALUES(?, ?, ?, {1})";

    String SELECT_TRIGGER_LISTENERS = "SELECT "
            + COL_TRIGGER_LISTENER + " FROM " + TABLE_PREFIX_SUBST
            + TABLE_TRIGGER_LISTENERS + " WHERE " + COL_TRIGGER_NAME
            + " = ? AND " + COL_TRIGGER_GROUP + " = ? AND " + SYSTEM_NAME_CONDITION;

    String DELETE_SIMPLE_TRIGGER = "DELETE FROM "
            + TABLE_PREFIX_SUBST + TABLE_SIMPLE_TRIGGERS + " WHERE "
            + COL_TRIGGER_NAME + " = ? AND " + COL_TRIGGER_GROUP + " = ? AND " + SYSTEM_NAME_CONDITION;

    String DELETE_CRON_TRIGGER = "DELETE FROM "
            + TABLE_PREFIX_SUBST + TABLE_CRON_TRIGGERS + " WHERE "
            + COL_TRIGGER_NAME + " = ? AND " + COL_TRIGGER_GROUP + " = ? AND " + SYSTEM_NAME_CONDITION;

    String DELETE_BLOB_TRIGGER = "DELETE FROM "
            + TABLE_PREFIX_SUBST + TABLE_BLOB_TRIGGERS + " WHERE "
            + COL_TRIGGER_NAME + " = ? AND " + COL_TRIGGER_GROUP + " = ? AND " + SYSTEM_NAME_CONDITION;

    String DELETE_TRIGGER = "DELETE FROM "
            + TABLE_PREFIX_SUBST + TABLE_TRIGGERS + " WHERE "
            + COL_TRIGGER_NAME + " = ? AND " + COL_TRIGGER_GROUP + " = ? AND " + SYSTEM_NAME_CONDITION;

    String SELECT_NUM_TRIGGERS_FOR_JOB = "SELECT COUNT("
            + COL_TRIGGER_NAME + ") FROM " + TABLE_PREFIX_SUBST
            + TABLE_TRIGGERS + " WHERE " + COL_JOB_NAME + " = ? AND "
            + COL_JOB_GROUP + " = ? AND " + SYSTEM_NAME_CONDITION;

    String SELECT_JOB_FOR_TRIGGER = "SELECT J."
            + COL_JOB_NAME + ", J." + COL_JOB_GROUP + ", J." + COL_IS_DURABLE
            + ", J." + COL_JOB_CLASS + ", J." + COL_REQUESTS_RECOVERY + " FROM " + TABLE_PREFIX_SUBST
            + TABLE_TRIGGERS + " T, " + TABLE_PREFIX_SUBST + TABLE_JOB_DETAILS
            + " J WHERE T." + COL_TRIGGER_NAME + " = ? AND T."
            + COL_TRIGGER_GROUP + " = ? AND T." + COL_JOB_NAME + " = J."
            + COL_JOB_NAME + " AND T." + COL_JOB_GROUP + " = J."
            + COL_JOB_GROUP + " AND T." + COL_SYSTEM_NAME + " = J." + COL_SYSTEM_NAME
            + "AND " + SYSTEM_NAME_CONDITION;

    String SELECT_TRIGGER = "SELECT *" + " FROM "
            + TABLE_PREFIX_SUBST + TABLE_TRIGGERS + " WHERE "
            + COL_TRIGGER_NAME + " = ? AND " + COL_TRIGGER_GROUP + " = ? AND " + SYSTEM_NAME_CONDITION;

    String SELECT_TRIGGER_DATA = "SELECT " +
            COL_JOB_DATAMAP + " FROM "
            + TABLE_PREFIX_SUBST + TABLE_TRIGGERS + " WHERE "
            + COL_TRIGGER_NAME + " = ? AND " + COL_TRIGGER_GROUP + " = ? AND " + SYSTEM_NAME_CONDITION;

    String SELECT_TRIGGER_STATE = "SELECT "
            + COL_TRIGGER_STATE + " FROM " + TABLE_PREFIX_SUBST
            + TABLE_TRIGGERS + " WHERE " + COL_TRIGGER_NAME + " = ? AND "
            + COL_TRIGGER_GROUP + " = ? AND " + SYSTEM_NAME_CONDITION;

    String SELECT_TRIGGER_STATUS = "SELECT "
            + COL_TRIGGER_STATE + ", " + COL_NEXT_FIRE_TIME + ", "
            + COL_JOB_NAME + ", " + COL_JOB_GROUP + " FROM "
            + TABLE_PREFIX_SUBST + TABLE_TRIGGERS + " WHERE "
            + COL_TRIGGER_NAME + " = ? AND " + COL_TRIGGER_GROUP + " = ? AND " + SYSTEM_NAME_CONDITION;

    String SELECT_SIMPLE_TRIGGER = "SELECT *" + " FROM "
            + TABLE_PREFIX_SUBST + TABLE_SIMPLE_TRIGGERS + " WHERE "
            + COL_TRIGGER_NAME + " = ? AND " + COL_TRIGGER_GROUP + " = ? AND " + SYSTEM_NAME_CONDITION;

    String SELECT_CRON_TRIGGER = "SELECT *" + " FROM "
            + TABLE_PREFIX_SUBST + TABLE_CRON_TRIGGERS + " WHERE "
            + COL_TRIGGER_NAME + " = ? AND " + COL_TRIGGER_GROUP + " = ? AND " + SYSTEM_NAME_CONDITION;

    String SELECT_BLOB_TRIGGER = "SELECT *" + " FROM "
            + TABLE_PREFIX_SUBST + TABLE_BLOB_TRIGGERS + " WHERE "
            + COL_TRIGGER_NAME + " = ? AND " + COL_TRIGGER_GROUP + " = ? AND " + SYSTEM_NAME_CONDITION;

    String SELECT_NUM_TRIGGERS = "SELECT COUNT("
            + COL_TRIGGER_NAME + ") " + " FROM " + TABLE_PREFIX_SUBST
            + TABLE_TRIGGERS + " WHERE " + SYSTEM_NAME_CONDITION;

    String SELECT_NUM_TRIGGERS_IN_GROUP = "SELECT COUNT("
            + COL_TRIGGER_NAME + ") " + " FROM " + TABLE_PREFIX_SUBST
            + TABLE_TRIGGERS + " WHERE " + COL_TRIGGER_GROUP + " = ? AND " + SYSTEM_NAME_CONDITION;

    String SELECT_TRIGGER_GROUPS = "SELECT DISTINCT("
            + COL_TRIGGER_GROUP + ") FROM " + TABLE_PREFIX_SUBST
            + TABLE_TRIGGERS + " WHERE " + SYSTEM_NAME_CONDITION;

    String SELECT_TRIGGERS_IN_GROUP = "SELECT "
            + COL_TRIGGER_NAME + " FROM " + TABLE_PREFIX_SUBST + TABLE_TRIGGERS
            + " WHERE " + COL_TRIGGER_GROUP + " = ? AND " + SYSTEM_NAME_CONDITION;

    String INSERT_CALENDAR = "INSERT INTO "
            + TABLE_PREFIX_SUBST + TABLE_CALENDARS + " (" + COL_CALENDAR_NAME
            + ", " + COL_CALENDAR + ", " + COL_SYSTEM_NAME + ") " + " VALUES(?, ?, {1})";

    String UPDATE_CALENDAR = "UPDATE " + TABLE_PREFIX_SUBST
            + TABLE_CALENDARS + " SET " + COL_CALENDAR + " = ? " + " WHERE "
            + COL_CALENDAR_NAME + " = ?  AND " + SYSTEM_NAME_CONDITION;

    String SELECT_CALENDAR_EXISTENCE = "SELECT "
            + COL_CALENDAR_NAME + " FROM " + TABLE_PREFIX_SUBST
            + TABLE_CALENDARS + " WHERE " + COL_CALENDAR_NAME + " = ? AND " + SYSTEM_NAME_CONDITION;

    String SELECT_CALENDAR = "SELECT *" + " FROM "
            + TABLE_PREFIX_SUBST + TABLE_CALENDARS + " WHERE "
            + COL_CALENDAR_NAME + " = ? AND " + SYSTEM_NAME_CONDITION;

    String SELECT_REFERENCED_CALENDAR = "SELECT "
            + COL_CALENDAR_NAME + " FROM " + TABLE_PREFIX_SUBST
            + TABLE_TRIGGERS + " WHERE " + COL_CALENDAR_NAME + " = ? AND " + SYSTEM_NAME_CONDITION;

    String DELETE_CALENDAR = "DELETE FROM "
            + TABLE_PREFIX_SUBST + TABLE_CALENDARS + " WHERE "
            + COL_CALENDAR_NAME + " = ? AND " + SYSTEM_NAME_CONDITION;

    String SELECT_NUM_CALENDARS = "SELECT COUNT("
            + COL_CALENDAR_NAME + ") " + " FROM " + TABLE_PREFIX_SUBST
            + TABLE_CALENDARS + " WHERE " + SYSTEM_NAME_CONDITION;

    String SELECT_CALENDARS = "SELECT " + COL_CALENDAR_NAME
            + " FROM " + TABLE_PREFIX_SUBST + TABLE_CALENDARS + " WHERE " + SYSTEM_NAME_CONDITION;

    String SELECT_NEXT_FIRE_TIME = "SELECT MIN("
            + COL_NEXT_FIRE_TIME + ") AS " + ALIAS_COL_NEXT_FIRE_TIME
            + " FROM " + TABLE_PREFIX_SUBST + TABLE_TRIGGERS + " WHERE "
            + COL_TRIGGER_STATE + " = ? AND " + COL_NEXT_FIRE_TIME + " >= 0 AND " + SYSTEM_NAME_CONDITION;

    String SELECT_TRIGGER_FOR_FIRE_TIME = "SELECT "
            + COL_TRIGGER_NAME + ", " + COL_TRIGGER_GROUP + " FROM "
            + TABLE_PREFIX_SUBST + TABLE_TRIGGERS + " WHERE "
            + COL_TRIGGER_STATE + " = ? AND " + COL_NEXT_FIRE_TIME + " = ? AND " + SYSTEM_NAME_CONDITION;

    String SELECT_NEXT_TRIGGER_TO_ACQUIRE = "SELECT "
            + COL_TRIGGER_NAME + ", " + COL_TRIGGER_GROUP + ", "
            + COL_NEXT_FIRE_TIME + ", " + COL_PRIORITY + " FROM "
            + TABLE_PREFIX_SUBST + TABLE_TRIGGERS + " WHERE "
            + COL_TRIGGER_STATE + " = ? AND " + COL_NEXT_FIRE_TIME + " < ? "
            + "AND (" + COL_NEXT_FIRE_TIME + " >= ?) AND " + SYSTEM_NAME_CONDITION
            + "ORDER BY "+ COL_NEXT_FIRE_TIME + " ASC, " + COL_PRIORITY + " DESC";

    String INSERT_FIRED_TRIGGER = "INSERT INTO "
            + TABLE_PREFIX_SUBST + TABLE_FIRED_TRIGGERS + " (" + COL_ENTRY_ID
            + ", " + COL_TRIGGER_NAME + ", " + COL_TRIGGER_GROUP + ", "
            + COL_IS_VOLATILE + ", " + COL_INSTANCE_NAME + ", "
            + COL_FIRED_TIME + ", " + COL_ENTRY_STATE + ", " + COL_JOB_NAME
            + ", " + COL_JOB_GROUP + ", " + COL_IS_STATEFUL + ", "
            + COL_REQUESTS_RECOVERY + ", " + COL_PRIORITY
            + ", " + COL_SYSTEM_NAME + ") VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, {1})";

    String UPDATE_INSTANCES_FIRED_TRIGGER_STATE = "UPDATE "
            + TABLE_PREFIX_SUBST + TABLE_FIRED_TRIGGERS + " SET "
            + COL_ENTRY_STATE + " = ? AND " + COL_FIRED_TIME + " = ? AND " + COL_PRIORITY+ " = ? WHERE "
            + COL_INSTANCE_NAME + " = ? AND " + SYSTEM_NAME_CONDITION;

    String SELECT_INSTANCES_FIRED_TRIGGERS = "SELECT * FROM "
            + TABLE_PREFIX_SUBST
            + TABLE_FIRED_TRIGGERS
            + " WHERE "
            + COL_INSTANCE_NAME + " = ? AND " + SYSTEM_NAME_CONDITION;

    String SELECT_INSTANCES_RECOVERABLE_FIRED_TRIGGERS = "SELECT * FROM "
            + TABLE_PREFIX_SUBST
            + TABLE_FIRED_TRIGGERS
            + " WHERE "
            + COL_INSTANCE_NAME + " = ? AND " + COL_REQUESTS_RECOVERY + " = ? AND " + SYSTEM_NAME_CONDITION;

    String SELECT_JOB_EXECUTION_COUNT = "SELECT COUNT("
            + COL_TRIGGER_NAME + ") FROM " + TABLE_PREFIX_SUBST
            + TABLE_FIRED_TRIGGERS + " WHERE " + COL_JOB_NAME + " = ? AND "
            + COL_JOB_GROUP + " = ? AND " + SYSTEM_NAME_CONDITION;

    String SELECT_FIRED_TRIGGERS = "SELECT * FROM "
            + TABLE_PREFIX_SUBST + TABLE_FIRED_TRIGGERS + " WHERE " + SYSTEM_NAME_CONDITION;

    String SELECT_FIRED_TRIGGER = "SELECT * FROM "
            + TABLE_PREFIX_SUBST + TABLE_FIRED_TRIGGERS + " WHERE "
            + COL_TRIGGER_NAME + " = ? AND " + COL_TRIGGER_GROUP + " = ? AND " + SYSTEM_NAME_CONDITION;

    String SELECT_FIRED_TRIGGER_GROUP = "SELECT * FROM "
            + TABLE_PREFIX_SUBST + TABLE_FIRED_TRIGGERS + " WHERE "
            + COL_TRIGGER_GROUP + " = ? AND " + SYSTEM_NAME_CONDITION;

    String SELECT_FIRED_TRIGGERS_OF_JOB = "SELECT * FROM "
            + TABLE_PREFIX_SUBST + TABLE_FIRED_TRIGGERS + " WHERE "
            + COL_JOB_NAME + " = ? AND " + COL_JOB_GROUP + " = ? AND " + SYSTEM_NAME_CONDITION;

    String SELECT_FIRED_TRIGGERS_OF_JOB_GROUP = "SELECT * FROM "
            + TABLE_PREFIX_SUBST
            + TABLE_FIRED_TRIGGERS
            + " WHERE "
            + COL_JOB_GROUP + " = ? AND " + SYSTEM_NAME_CONDITION;

    String DELETE_FIRED_TRIGGER = "DELETE FROM "
            + TABLE_PREFIX_SUBST + TABLE_FIRED_TRIGGERS + " WHERE "
            + COL_ENTRY_ID + " = ? AND " + SYSTEM_NAME_CONDITION;

    String DELETE_INSTANCES_FIRED_TRIGGERS = "DELETE FROM "
            + TABLE_PREFIX_SUBST + TABLE_FIRED_TRIGGERS + " WHERE "
            + COL_INSTANCE_NAME + " = ? AND " + SYSTEM_NAME_CONDITION;

    String DELETE_VOLATILE_FIRED_TRIGGERS = "DELETE FROM "
            + TABLE_PREFIX_SUBST + TABLE_FIRED_TRIGGERS + " WHERE "
            + COL_IS_VOLATILE + " = ? AND " + SYSTEM_NAME_CONDITION;

    String DELETE_NO_RECOVERY_FIRED_TRIGGERS = "DELETE FROM "
            + TABLE_PREFIX_SUBST
            + TABLE_FIRED_TRIGGERS
            + " WHERE "
            + COL_INSTANCE_NAME + " = ?" + COL_REQUESTS_RECOVERY + " = ? AND " + SYSTEM_NAME_CONDITION;

    String SELECT_FIRED_TRIGGER_INSTANCE_NAMES =
            "SELECT DISTINCT " + COL_INSTANCE_NAME + " FROM "
                    + TABLE_PREFIX_SUBST
                    + TABLE_FIRED_TRIGGERS + " WHERE " + SYSTEM_NAME_CONDITION ;

    String INSERT_SCHEDULER_STATE = "INSERT INTO "
            + TABLE_PREFIX_SUBST + TABLE_SCHEDULER_STATE + " ("
            + COL_INSTANCE_NAME + ", " + COL_LAST_CHECKIN_TIME + ", "
            + COL_CHECKIN_INTERVAL + ", " + COL_SYSTEM_NAME + ") VALUES(?, ?, ?, {1})";

    String SELECT_SCHEDULER_STATE = "SELECT * FROM "
            + TABLE_PREFIX_SUBST + TABLE_SCHEDULER_STATE + " WHERE "
            + COL_INSTANCE_NAME + " = ? AND " + SYSTEM_NAME_CONDITION;

    String SELECT_SCHEDULER_STATES = "SELECT * FROM "
            + TABLE_PREFIX_SUBST + TABLE_SCHEDULER_STATE + " WHERE " + SYSTEM_NAME_CONDITION;

    String DELETE_SCHEDULER_STATE = "DELETE FROM "
            + TABLE_PREFIX_SUBST + TABLE_SCHEDULER_STATE + " WHERE "
            + COL_INSTANCE_NAME + " = ? AND " + SYSTEM_NAME_CONDITION;

    String UPDATE_SCHEDULER_STATE = "UPDATE "
            + TABLE_PREFIX_SUBST + TABLE_SCHEDULER_STATE + " SET "
            + COL_LAST_CHECKIN_TIME + " = ? WHERE "
            + COL_INSTANCE_NAME + " = ? AND " + SYSTEM_NAME_CONDITION;

    String INSERT_PAUSED_TRIGGER_GROUP = "INSERT INTO "
            + TABLE_PREFIX_SUBST + TABLE_PAUSED_TRIGGERS + " ("
            + COL_TRIGGER_GROUP + ", " + COL_SYSTEM_NAME + ") VALUES(?, {1})";

    String SELECT_PAUSED_TRIGGER_GROUP = "SELECT "
            + COL_TRIGGER_GROUP + " FROM " + TABLE_PREFIX_SUBST
            + TABLE_PAUSED_TRIGGERS + " WHERE " + COL_TRIGGER_GROUP + " = ? AND " + SYSTEM_NAME_CONDITION;

    String SELECT_PAUSED_TRIGGER_GROUPS = "SELECT "
            + COL_TRIGGER_GROUP + " FROM " + TABLE_PREFIX_SUBST
            + TABLE_PAUSED_TRIGGERS + " WHERE " + SYSTEM_NAME_CONDITION;

    String DELETE_PAUSED_TRIGGER_GROUP = "DELETE FROM "
            + TABLE_PREFIX_SUBST + TABLE_PAUSED_TRIGGERS + " WHERE "
            + COL_TRIGGER_GROUP + " = ? AND " + SYSTEM_NAME_CONDITION;

    String DELETE_PAUSED_TRIGGER_GROUPS = "DELETE FROM "
            + TABLE_PREFIX_SUBST + TABLE_PAUSED_TRIGGERS + " WHERE " + SYSTEM_NAME_CONDITION;

    //  CREATE TABLE qrtz_scheduler_state(INSTANCE_NAME VARCHAR2(80) NOT NULL,
    // LAST_CHECKIN_TIME NUMBER(13) NOT NULL, CHECKIN_INTERVAL NUMBER(13) NOT
    // NULL, PRIMARY KEY (INSTANCE_NAME));
}
