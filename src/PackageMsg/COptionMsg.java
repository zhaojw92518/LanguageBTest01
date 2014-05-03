package PackageMsg;

import Defines.DeduceDef;

public class COptionMsg {
	public String left_factor = null, right_factor = null;
	public DeduceDef method = null;
	public COptionMsg(String in_left_factor, String in_right_factor, DeduceDef in_method){
		left_factor = in_left_factor;
		right_factor = in_right_factor;
		method = in_method;
	}
}
