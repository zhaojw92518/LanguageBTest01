package ContextUI;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.HashMap;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;

public class CInOutIdPanel extends JPanel {
	private CInputModel input_model = null;
	private COutputModel output_model = null;
	private CIterationsModel iterations_model = new CIterationsModel("0");
	private JLabel input_label = new JLabel("Input Ids");
	private JLabel output_label = new JLabel("Output Ids");
	private JLabel iterations_label = new JLabel("Iterations");
	
	private JTable input_table = new JTable();
	private JTable output_table = new JTable();
	private JTable iterations_table = new JTable();
	
	public CInOutIdPanel(){
		super();
		
		BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);		
		this.setLayout(layout);
		
		input_table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		input_table.setRowHeight(25);
		output_table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		output_table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				iterations_table.clearSelection();
			}
		});
		output_table.setRowHeight(25);
		iterations_table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		iterations_table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				output_table.clearSelection();
			}
		});
		iterations_table.setRowHeight(25);
		
		this.add(input_label);
		this.add(input_table);
		this.add(output_label);
		this.add(output_table);
		this.add(iterations_label);
		this.add(iterations_table);
		
		this.setVisible(true);
	}
	
	public void set_value(int in_index, String in_value_str){
		output_model.set_value(in_index, in_value_str);
	}
	
	public String get_selected_id(){
		return (String) output_table.getValueAt(output_table.getSelectedRow(), 0);
	}
	
	public void set_selected_id_value(String in_value){
		if(output_table.getSelectedRow() != -1){
			output_model.set_value(output_table.getSelectedRow(), in_value);
			output_table.setModel(output_model);
		}
		if(iterations_table.getSelectedRow() != -1){
			iterations_model.update_iterations_input(in_value);
			iterations_table.setModel(iterations_model);
		}
	}
	
	public void update(String[] in_input_array, String[] in_output_array, int in_input_size, int in_output_size){
		input_model = new CInputModel(in_input_array, in_input_size);
		output_model = new COutputModel(in_output_array, in_output_size);
		
		input_table.setModel(input_model);
		output_table.setModel(output_model);
	}
	
	public void update_iterations(String in_iterations_count, String in_iterations_input){
		//iterations_model = new CIterationsModel(in_iterations_count, in_iterations_input);
		iterations_model.update_iterations_count(in_iterations_count);
		iterations_table.setModel(iterations_model);
	}
	
	public void update_output_values(HashMap<String, String> in_map){
		output_model.set_n_plus_one_value(in_map);
		output_table.setModel(output_model);
	}
	
	public String get_iterations_input(){
		return (String)iterations_model.getValueAt(1, 1);
	}
	
	public HashMap<String, String> get_id_value_map(){
		return output_model.get_id_value_map();
	}
	
	class CInputModel extends AbstractTableModel{
		private String[] table_data;
		private int array_size;
		
		public CInputModel(String[] in_table_data, int in_array_size){
			table_data = in_table_data;
			array_size = in_array_size;
		}
		@Override
        public int getRowCount()
        {
            return array_size;
        }
        
        @Override
        public int getColumnCount()            
        {
            return 1;
        }
        
        @Override
        public Object getValueAt(int row, int column)
        {        
            return table_data[row];
        }
        
        //Used by the JTable object to set the column names
        @Override
        public String getColumnName(int column) {
            return "Input Value";
        }
        
        //Used by the JTable object to render different
        //functionality based on the data type
        @Override
        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }
        
        @Override
        public boolean isCellEditable(int row, int column)
        {
        	return false;
        }
		
	}
	
	class COutputModel extends AbstractTableModel{
		private String[] output_id, output_value;
		private int table_size;
		
		public COutputModel(String[] in_output_id, int in_table_size){
			output_id = in_output_id;
			table_size = in_table_size;
			output_value = new String[in_table_size];
			for(int i = 0; i < table_size; i++){
				output_value[i] = "";
			}
		}
		
		public void set_value(int in_index, String in_value_str){
			output_value[in_index] = in_value_str;
		}
		
		public void set_n_plus_one_value(HashMap<String, String> in_map){
			for(int i = 0; i < table_size; i++){
				output_value[i] = in_map.get(output_id[i]);
			}
		}
		
		@Override
        public int getRowCount()
        {
            return table_size;
        }
        
        @Override
        public int getColumnCount()            
        {
            return 2;
        }
        
        @Override
        public Object getValueAt(int row, int column)
        {        
            String return_result = null;
        	if(column == 0){
            	return_result = output_id[row];
            }
        	else{
        		return_result = output_value[row];
        	}
        	return return_result;
        }
        
        //Used by the JTable object to set the column names
        @Override
        public String getColumnName(int column) {
            if(column == 0){
            	return "Identifier";
            }
            else{
            	return "Value";
            }
        }
        
        //Used by the JTable object to render different
        //functionality based on the data type
        @Override
        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }
        
        @Override
        public boolean isCellEditable(int row, int column)
        {
        	return false;
        }
        
        public HashMap<String, String> get_id_value_map(){
        	HashMap<String, String> return_result = new HashMap<String, String>();
        	for(int i = 0; i < table_size; i++){
        		return_result.put(output_id[i], output_value[i]);
        	}
        	return return_result;
        }
	}
	
	class CIterationsModel extends AbstractTableModel{
		private String[][] table_datas = new String[2][2];
		
		public CIterationsModel(String in_iterations_count){
			table_datas[0][0] = "Iterations(_)";
			table_datas[1][0] = "Iterations(_) Input";
			table_datas[0][1] = in_iterations_count;
			table_datas[1][1] = "";
		}
		
		public CIterationsModel(String in_iterations_count, String in_iterations_input){
			table_datas[0][0] = "Iterations(_)";
			table_datas[1][0] = "Iterations(_) Input";
			table_datas[0][1] = in_iterations_count;
			table_datas[1][1] = in_iterations_input;
		}
		
		public void update_iterations_count(String in_iterations){
			table_datas[0][1] = in_iterations;
		}
		
		public void update_iterations_input(String in_iterations){
			table_datas[1][1] = in_iterations;
		}
		
		@Override
		public int getColumnCount() {
			return 2;
		}

		@Override
		public int getRowCount() {
			return 2;
		}

		@Override
		public Object getValueAt(int row, int column) {
			return table_datas[row][column];
		}
		
		@Override
        public String getColumnName(int column) {
            if(column == 0){
            	return "Identifier";
            }
            else{
            	return "Value";
            }
        }
        
        //Used by the JTable object to render different
        //functionality based on the data type
        @Override
        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }
        
        @Override
        public boolean isCellEditable(int row, int column)
        {
        	return false;
        }
	}
}
