import java.awt.Color;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfTextFormat {
    static String date;
    static String time;
    static String title;
    static String description;
	
	public PdfTextFormat(String dte, String tme, String ttl, String dscrptn) {
        date = dte;
        time = tme;
        title = ttl;
        description = dscrptn;
    }

	public static void createPDF(){
		
		Font titleFont =  FontFactory.getFont(FontFactory.TIMES, 16f, Font.UNDERLINE, BaseColor.BLUE);
		
		Font commentsFont = FontFactory.getFont(FontFactory.TIMES, 12f, Font.ITALIC, BaseColor.BLACK);
		
		Font endNoteFont =  FontFactory.getFont(FontFactory.TIMES, 10f, Font.BOLD, BaseColor.BLACK);
		
		Font bodyFont =  FontFactory.getFont(FontFactory.TIMES, 14f, BaseColor.BLACK);
		
		Paragraph title1 = new Paragraph("IC Lab Reservation Confirmation", titleFont); 
		title1.setAlignment(Element.ALIGN_CENTER);
		
		Paragraph space = new Paragraph(" ");
		
		Paragraph divider = new Paragraph("\n \n \n \n \n \n \n \n \n \n \n \n \n______________________________________________________________________________");
		
		Paragraph body = new Paragraph("Your reservation has been created for " + date + "\n \nTime: " + time + "\n \nTitle: " + title + "\n \nDescription: " + description, bodyFont);
		
		Paragraph endNote = new Paragraph("Program created by Armaan R. Shah", endNoteFont);
		endNote.setAlignment(Element.ALIGN_RIGHT);
		
		Paragraph comments = new Paragraph("If any of the above information is incorrect / you wish to change the above information, please return to the Lab Reservation Application and follow the steps below"
				+ " \n \n1. Log into your account. \n \n2. Click on the 'Delete a reservation' button.\n \n4. Select the reservation you would like to delete. "
				+ "\n \n5. If you are sure that this is the reservation you would like to delete, then proceed to click 'Delete'. \nNOTE: This action is irreversibe.", commentsFont);
		
		
		try {
			Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream("your-pdf-location"));
			document.open();
			document.add(title1);
			document.add(space);
			document.add(space);
			document.add(body);
			document.add(space);
			document.add(divider);
			document.add(space);
			document.add(comments);
			document.add(space);
			document.add(space);
			document.add(endNote);
			document.close();
		}catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Program executed!");
	}

}




