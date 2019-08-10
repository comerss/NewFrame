package com.comers.shenwu.instant_run.android.tools.ir.common;

public abstract interface ProtocolConstants
{
  public static final long PROTOCOL_IDENTIFIER = 890269988L;
  public static final int PROTOCOL_VERSION = 4;
  public static final int MESSAGE_PATCHES = 1;
  public static final int MESSAGE_PING = 2;
  public static final int MESSAGE_PATH_EXISTS = 3;
  public static final int MESSAGE_PATH_CHECKSUM = 4;
  public static final int MESSAGE_RESTART_ACTIVITY = 5;
  public static final int MESSAGE_SHOW_TOAST = 6;
  public static final int MESSAGE_EOF = 7;
  public static final int MESSAGE_SEND_FILE = 8;
  public static final int MESSAGE_SHELL_COMMAND = 9;
  public static final int UPDATE_MODE_NONE = 0;
  public static final int UPDATE_MODE_HOT_SWAP = 1;
  public static final int UPDATE_MODE_WARM_SWAP = 2;
  public static final int UPDATE_MODE_COLD_SWAP = 3;
}


/* Location:              /Volumes/Work/works/Diooto/app/build/intermediates/incremental-runtime-classes/debug/instant-run.jar!/com/android/tools/ir/common/ProtocolConstants.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */