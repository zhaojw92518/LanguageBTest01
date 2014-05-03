import java.util.LinkedList;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

class CQuaManager {	
	private LinkedList<CQuaternion> quaternions = new LinkedList<CQuaternion>();
	
	public void push_back_quaternion(CQuaternion in_qua){
		if(in_qua != null){
			quaternions.add(in_qua);
		}
	}
	
	public void push_back_quaternion(QuaDef in_type){
		this.push_back_quaternion(new CQuaternion(in_type, CQuaternion.NO_USE_LINE_NUM));
	}
	
	public void push_back_quaternion(QuaDef in_type, int in_line_num){
		this.push_back_quaternion(new CQuaternion(in_type, in_line_num));
	}
	
	public void push_back_quaternion(QuaDef in_type, CData in_data_0, int in_line_num){
		this.push_back_quaternion(new CQuaternion(in_type, in_data_0, in_line_num));
	}
	
	public void push_back_quaternion(QuaDef in_type, CData in_data_0, CData in_data_1, int in_line_num){
		this.push_back_quaternion(new CQuaternion(in_type, in_data_0, in_data_1, in_line_num));
	}
	
	public void push_back_quaternion(QuaDef in_type, CData in_data_0, CData in_data_1, CData in_data_2, int in_line_num){
		this.push_back_quaternion(new CQuaternion(in_type, in_data_0, in_data_1, in_data_2, in_line_num));
	}
	
	public void print_all_quaternions(){
		for (CQuaternion cur_qua : quaternions) {
			System.out.println(cur_qua.toString());
		}
	}
	
	public void file_out_all_quaternions(String out_file_name) throws IOException{
		try {
			File out_file = new java.io.File(out_file_name);
			FileOutputStream out_file_stream = new FileOutputStream(out_file);
			BufferedWriter out_file_buffer = new BufferedWriter(new OutputStreamWriter(out_file_stream));;
			for (CQuaternion cur_qua : quaternions) {
				out_file_buffer.write(cur_qua.toString());
				out_file_buffer.newLine();
			}
			out_file_buffer.close();
			out_file_stream.close();
			out_file = null;
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void set_last_qua_line_num(int in_line_num){
		quaternions.get(quaternions.size() - 1).line_num = in_line_num;
	}
	
	public LinkedList<CQuaternion> get_quaternions(){
		return quaternions;
	}
}
