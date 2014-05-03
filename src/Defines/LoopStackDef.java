package Defines;

public enum LoopStackDef {
	//CLoopBlockStack的状态
	ERROR,//错误状态
	EMPTY,//栈空
	UNCLOSED,//循环扫描尚未完毕
	CLOSED,//循环扫描完毕
	
	//CLoopBlockMgr的状态
	COMPLETED,//处理完毕
	UNCOMPLETED;//尚未处理完毕
}
