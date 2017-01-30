
package govind.excel.reader;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ExcelReader extends HttpServlet {
Object obj2= null;
Object obj3 = null;
double[] myList; 
String[] str = new String[10];
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, JSONException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
            // readXLSXFile();
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
           // out.println("<meta http-equiv=\"refresh\" content=\"0; url=/ExcelReaderWeb/ExcelReader\" />");
            out.println("<head>");
            out.println("<title>Servlet ExcelReader</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet reader at " + request.getContextPath() + "</h1>");
            String fname=request.getParameter("datafile");
            // PrintWriter out = response.getWriter(); 
           
            ArrayList ar2=new ArrayList();
             ar2 = readXLSXFile(fname);
             String[] data_value = new String[ar2.size()];
           
              Gson gson = new Gson();
            JSONObject obj5 = new JSONObject();
            JSONArray ja1 = new JSONArray();
            int j=0;
           for ( Object obj : ar2){
            //for (int i =1; i<=ar2.size();i++) {
                 if (obj instanceof String) {
                   out.println(obj);
                    obj5.put("labels", obj);
                                  out.println(obj5);
                        ja1.put(obj5);
                   obj2 = obj;
                   str[j]= obj.toString();
                   j++;
                 //str[i]= obj.toString();
                // i++;
                        //  request.setAttribute("label", str[10]);
 // request.getRequestDispatcher("graph.jsp").forward(request, response);
                   out.println("<br>");
                  //  labels: [obj];
   
                 }
                //  
           }
           // HttpSession session=request.getSession(true);
           // session.setAttribute("labels", ja1);
            //RequestDispatcher rd = request.getRequestDispatcher("graph.jsp");
            //rd.forward(request, response);
             /* for(int i=0;i<=ja1.length();i++){
                  
                Object ob= ja1.getJSONObject(i);
                out.println(ob);
                  }*/
           //  request.setAttribute("label", str[10]);
                  //   RequestDispatcher rd = request.getRequestDispatcher("graph.jsp");
                     // rd.forward(request, response);
              //  Gson gson = new Gson();
            JSONObject obj1 = new JSONObject();
            JSONArray ja = new JSONArray();
           //  Object obj3 = null;
          for( Object obj : ar2){
             //for (int i = 1; i<=ar2.size();i++) {
                 if (obj instanceof Double) {
                     out.println(obj);
                     obj1.put("data", obj);
                                  out.println(obj1);
                        ja.put(obj1);
                     //HttpSession session=request.getSession(true);
                      //session.setAttribute("data1", ja);
                       //RequestDispatcher rd = request.getRequestDispatcher("graph.jsp");
                       //rd.forward(request, response);
                     obj3 = obj;
                   // myList=parseFloatobj.toString();
                     JSONObject mainObj = new JSONObject();
                     mainObj.put("labels", ja);
                   //  obj.put("name", "foo");
                  
                //  request.setAttribute("value", obj3);
  // request.getRequestDispatcher("/graph.jsp").forward(request, response);
                   out.println("<br>");
                  //  labels: [obj];
   
                 }
                  
                  
             //    request.setAttribute("label", obj2);
                   //   RequestDispatcher rd = request.getRequestDispatcher("graph.jsp");
                       //  rd.forward(request, response);
                 
                  
            }
            
              obj1.put("labels", ja);
              obj1.get("labels");
              //for(int i=0;i<=ja.length();i++){
                  
                // Object ob= ja.getJSONObject(i);
                 //out.println(ob);
                  //}
              
              
                   //out.println(obj1);
            
          
           for(int i=0;i<ar2.size();i++)
            {
                
               Object o = ar2.get(i);
              // out.println(o);
            }
                  // out.println("yessssss");
               // if(o instanceof String || o instanceof Float || o instanceof Integer)
               // {
              
               // out.println("\n" + o.toString());
              //  out.println("<br>");
               // }
              //  }
            
             
            out.println("<table  border=\\\"1\\\">");
            out.println("<tr>");
             for (int i = 0; i < ar2.size(); i++) {
            out.println("<td>" + ar2.get(i) + "</td>");
            if (i>0 && (i+1)%2==0) {
                out.println("</tr><tr>");
            }
             } 

 /*  out.println("Printing elements from first to last:"); 
   for (Object value : o) {
           Integer[] ar = new Integer[ar2.size()] ;
            ar = ar2.toArray(ar);
           ut.println( value);
           out.println(value);
             
                }*/
//request.setAttribute("label", obj2);
      //   getServletContext().getRequestDispatcher("/graph.jsp").forward(request, response);
  //request.setAttribute("dataset", obj3);
       //  getServletContext().getRequestDispatcher("/graph.jsp").forward(request, response);
  
          //   request.setAttribute("value", obj2);
                   //     RequestDispatcher rd1 = request.getRequestDispatcher("/graph.jsp");
                      //    rd1.forward(request, response);
                         // request.setAttribute("label", obj3);
                         // RequestDispatcher rd = request.getRequestDispatcher("/graph.jsp");
                         // rd.forward(request, response);
                          
                              /* request.setAttribute("label", obj2);
    request.getRequestDispatcher("/graph.jsp").forward(request, response);
    request.setAttribute("value", obj3);
    request.getRequestDispatcher("/graph.jsp").forward(request, response);*/
                         out.println("<a href=\"/ExcelReaderWeb/graph.jsp?value2="+ar2+"\">create graph</a>");
                              out.println("<br><br>");
                              out.println("<button type=\"button\">Create Graph</button>");
            out.println("</body>");
            out.println("</html>");
            
         
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    try {
        processRequest(request, response);
    } catch (JSONException ex) {
        Logger.getLogger(ExcelReader.class.getName()).log(Level.SEVERE, null, ex);
    }
             String fname=request.getParameter("datafile");
             System.out.println(fname);
             PrintWriter out = response.getWriter();
            ArrayList ar2=new ArrayList();
          /*  ArrayList ar3=new ArrayList();
            ar3= getContents(fname);
            for(int i=0;i<ar3.size();i++)
            {
                Object o = ar3.get(i);
 
                if(o instanceof String || o instanceof Float || o instanceof Integer)
                out.println("Value is "+o.toString());    
                }*/
            ar2 = readXLSXFile(fname);
            for(int i=0;i<ar2.size();i++)
            {
                Object o = ar2.get(i);
                 //  out.println("yessssss");
                if(o instanceof String || o instanceof Float || o instanceof Integer)
                out.println("Value is "+o.toString());
                }
              request.setAttribute("label", obj2);
             getServletContext().getRequestDispatcher("/graph.jsp").forward(request, response);
  request.setAttribute("dataset", obj3);
             getServletContext().getRequestDispatcher("/graph.jsp").forward(request, response);
              request.setAttribute("pieDataList", obj2);
        RequestDispatcher requestDispatcher = request
                .getRequestDispatcher("/graph.jsp");
        requestDispatcher.forward(request, response);
          request.setAttribute("pieDataValues", obj3);
        RequestDispatcher requestDispatcher1 = request
                .getRequestDispatcher("/graph.jsp");
        requestDispatcher1.forward(request, response);
                          
    
    }
    
    
    public ArrayList readXLSXFile(String fileName) {
		InputStream XlsxFileToRead = null;
                System.out.println(fileName);
		XSSFWorkbook workbook = null;
                 ArrayList arl=new ArrayList();
		try {
			XlsxFileToRead = new FileInputStream(fileName);
			
			//Getting the workbook instance for xlsx file
			workbook = new XSSFWorkbook(XlsxFileToRead);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		//getting the first sheet from the workbook using sheet name. 
		// We can also pass the index of the sheet which starts from '0'.
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		XSSFRow row;
		XSSFCell cell;
                
                //String[] StrArr = null;
               // int i = 0;
                
		
		//Iterating all the rows in the sheet
		Iterator rows = sheet.rowIterator();

		while (rows.hasNext()) {
                    
			row = (XSSFRow) rows.next();
			
			//Iterating all the cells of the current row
			Iterator cells = row.cellIterator();
                        System.out.println(cells);

			while (cells.hasNext()) {
                        //    i++;
                            
				cell = (XSSFCell) cells.next();
				if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
					System.out.print(cell.getStringCellValue() + " ");
                                        arl.add(cell.getStringCellValue());
                                        
				} else if (cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
					System.out.print(cell.getNumericCellValue() + " ");
                                         arl.add(cell.getNumericCellValue());
                                        
				} else if (cell.getCellType() == XSSFCell.CELL_TYPE_BOOLEAN) {
					System.out.print(cell.getBooleanCellValue() + " ");
                                        arl.add(cell.getBooleanCellValue());

				} else { // //Here if require, we can also add below methods to
							// read the cell content
							// XSSFCell.CELL_TYPE_BLANK
							// XSSFCell.CELL_TYPE_FORMULA
							// XSSFCell.CELL_TYPE_ERROR
				}
			}
			System.out.println();
			try {
				XlsxFileToRead.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
                }
                return arl;
    }    
    
    
     /* public ArrayList getContents(String fname)
     {
          String value = null,value1;
          ArrayList arl=new ArrayList();
          try {
                    String excelContent = "";
                  ////////  POIFSFileSystem pf = new POIFSFileSystem(new FileInputStream(fname));
                    POIFSFileSystem pf = new POIFSFileSystem(new FileInputStream(fname));
                    File f = new File("/home/edeewan/sridocuments/product.txt");
                    FileOutputStream os = new FileOutputStream(f);
                    PrintWriter pw = new PrintWriter(os);

                    HSSFWorkbook wb = new HSSFWorkbook(pf);
                    HSSFSheet hs = wb.getSheetAt(0);

                    int first_row_num = hs.getFirstRowNum();
                    int last_row_num = hs.getLastRowNum();
                    //System.out.println("The first row's number is " + first_row_num);
                    short first_cell_num = (short)0;
                    short last_cell_num = (short)0;
                    short temp = 2;

                    int type_cell = 0;
                    int cell_num_counter = 0;

                    //ArrayList arl=new ArrayList();

                    //System.out.println("The last physically defined row in the excel sheet is numbered" + last_row_num);

                    try {   
                              for( int i = first_row_num; i <= last_row_num; i++){
                                   HSSFRow r = hs.getRow(i);
                                   HSSFCell c = null;
     
                                   if(i == 0){
                                        first_cell_num = r.getFirstCellNum();
                                        last_cell_num = r.getLastCellNum();
                                        System.out.println("first cell number .."+first_cell_num);
                                        System.out.println("last cell number .."+last_cell_num);
                                        temp += last_cell_num;
                                        //System.out.println("The last cell's number in the first row is " + last_cell_num);
                                   } 
          
                                   if(r == null){
                                        cell_num_counter = 0;
                                   }
                                   else {
                                        System.out.println("the first cell's number in the row is" + first_cell_num + "The last cell number in the row is" + last_cell_num); //*test*/
                                  /* for(int j = 0; j <= (int)last_cell_num; j++){

                                        if( (c = r.getCell((short)j))== null){
                                             type_cell = 3;
                                        }
                                        else { 
                                             c = r.getCell((short)j);
                                             type_cell = c.getCellType();
                                        }
                                        switch(type_cell){

                                             case 0: // NUMERIC TYPE
                                                  //System.out.println("Cell contains numeric value");
                                                  double value0 = c.getNumericCellValue();
                                                  value = String.valueOf(value0);
                                                  arl.add(value);
                                                  //System.out.println("values..."+arl.get(j));
                                                  excelContent +=value+",";
                                                  //System.out.println("The value contained is" + " " + value0);
                                                  pw.println("\n");
                                                  //String value = String.valueOf(value0);
                                                  if(cell_num_counter == (int)temp + 1){                // replace 59 by last_cell_num
                                                       //System.out.println("LAST CELL NUMBER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! " + cell_num_counter); test, should be deleted later
                                                       pw.println(value); 
                                                       pw.flush();
                                                       cell_num_counter = 0;
                                                  }
                                                  else {
                                                       pw.print(value + ",");
                                                       pw.flush();
                                                       cell_num_counter++;
                                                  }
                                                  break;

                                             case 1: // CELL_TYPE_STRING
                                                  //System.out.println("Cell contains string value");
                                                  value1 = c.getStringCellValue();
                                                  arl.add(value1);
                                                  //System.out.println("Question Values...."+arl.get(j));
                                                  excelContent += value1+",";
                                                  if(cell_num_counter == (int)temp + 1){                  // replace 59 by last_cell_num
                                                       pw.println(value1);
                                                       pw.flush();
                                                       cell_num_counter = 0;
                                                  }
                                                  else {
                                                       pw.print(value1 + ",");
                                                       pw.flush();
                                                       cell_num_counter++;
                                                  }
                                                  //System.out.println("The value contained in the cell is" + " " + value1);
                                                  break;

                                             /* case 2: // CELL_TYPE_FORMULA
                                                       //System.out.println("Cell contains formula type value");
                                                       String value2 = c.getCellFormula();
                                                       excelContent += value2;
                                                       if(cell_num_counter == (int)temp + 1){                                          // replace 59 by last_cell_num
                                                            //System.out.println("LAST CELL NUMBER " + cell_num_counter); // test, should be deleted later
                                                            pw.println(value2);
                                                            pw.flush();
                                                            cell_num_counter = 0;
                                                       }
                                                       else{
                                                            pw.print(value2 + ",");
                                                            pw.flush();
                                                            cell_num_counter++;
                                                       }
                                                       System.out.println("The value contained in the cell is" + " " + value2);
                                                       break;

                                                  case 3: // CELL_TYPE_BLANK
                                                       //System.out.println("Cell contains blank value");
                                                       if(cell_num_counter == (int)temp - 1){
                                                            pw.println("null ");
                                                            pw.flush();
                                                            cell_num_counter = 0;
                                                       }
                                                       else {
                                                            pw.print("null " + ",");
                                                            pw.flush();
                                                            cell_num_counter++;
                                                       }
                                                       break;

                                                  /*case 4: // CELL_TYPE_BOOLEAN
                                                       System.out.println("Cell contains boolean type value");
                                                       boolean value3 = c.getBooleanCellValue();
                                                       System.out.println("The boolean value contained in the cell is" + " " + value3);
                                                       if(cell_num_counter == (int)temp - 1){
                                                            pw.println(value3);
                                                            pw.flush();
                                                            cell_num_counter = 0;
                                                       }
                                                       else{
                                                            pw.print(value3 + ",");
                                                            pw.flush();
                                                            cell_num_counter++;
                                                       }
                                                       break;

                                                  case 5: // CELL_TYPE_ERROR
                                                       System.out.println("Cell contains error code");
                                                       byte value4 = c.getErrorCellValue();
                                                       System.out.println("The error code contained in the cell is" + " " +value4);
                                                       if(cell_num_counter == (int)temp - 1){
                                                            cell_num_counter = 0;
                                                       }
                                                       else {
                                                            cell_num_counter++;
                                                       }
                                                       break;

                                             default: ;
                                        }
                                   }
                                   arl.add(value);
                                   }
                              } 
                              System.out.println("excel sheet values.."+excelContent);
                    }
                    catch(Exception e1){
                         e1.printStackTrace();
                    }
          }
          catch( IOException e){
               e.printStackTrace();
          }
          return arl;
     }*/
    
     
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    try {
        processRequest(request, response);
    } catch (JSONException ex) {
        Logger.getLogger(ExcelReader.class.getName()).log(Level.SEVERE, null, ex);
    }
        doGet(request,response);
            
                }
    }


    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
   // @Override
  //  public String getServletInfo() {
       // return "Short description";
   // }// </editor-fold>

//}
