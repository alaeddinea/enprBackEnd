package com.enpr.ExporterPDF;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.enpr.config.ConfigShaping;
import com.enpr.dao.ConsultationEleveRepository;
import com.enpr.dao.PenaliteEleveRepository;
import com.enpr.dao.RepoEleveRepository;
import com.enpr.model.ConsultationEleve;
import com.enpr.model.Eleve;
import com.enpr.model.PenaliteEleve;
import com.enpr.model.RepoEleve;
import com.enpr.model.Specialite;
import com.ibm.icu.text.ArabicShapingException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import com.itextpdf.text.pdf.codec.Base64;
import com.itextpdf.text.Image;
public class EleveExporterPDF {

	private  final RepoEleveRepository repoEleveRepository  ;
	private  final  ConsultationEleveRepository consultationEleveRepository;
	private  final PenaliteEleveRepository penaliteEleveRepository;
	public EleveExporterPDF(RepoEleveRepository repoEleveRepository, ConsultationEleveRepository consultationEleveRepository,PenaliteEleveRepository penaliteEleveRepository) {
		this.repoEleveRepository=repoEleveRepository;
		this.consultationEleveRepository=consultationEleveRepository;
		this.penaliteEleveRepository=penaliteEleveRepository;
	}
	/*-------------------------------Config Global---------------------------------*/

	public static final Font FONT = new Font();
    public static final Font BOLD = new Font(FontFamily.HELVETICA, 12, Font.BOLD);

    public ByteArrayInputStream export( Eleve eleve ) 
    		throws DocumentException, IOException, ArabicShapingException {
    	
    	
         	ByteArrayOutputStream out = new ByteArrayOutputStream();
	        Rectangle layout = new Rectangle(PageSize.A4);
	        Document document = new Document(layout);
	        PdfWriter.getInstance(document, out );
	        document.open();


	        
	        ConfigShaping boldConf = new ConfigShaping();
	        
	        
	        Font boldfontLabelTop = boldConf.getFontForArabic(12);
	        Font boldfontLabelAmiriDate = boldConf.getFontForArabic(12);
	        Font boldfontLabelAmiriinfo = boldConf.getFontForArabic(11);
	        
	        PdfPTable tab  = new PdfPTable(1);
		    tab.setWidthPercentage(100);
	        
		    Phrase ptab;
	        PdfPCell ctab;
	        
	        ptab =  new Phrase(  boldConf.format("الجمهورية التونسية ") ,boldfontLabelTop);
	        ctab = new PdfPCell(ptab);
	        ctab.setHorizontalAlignment(Element.ALIGN_RIGHT);
	        ctab.setBorder(0);
	         ctab.setPaddingRight(27f);
		    tab.addCell(ctab);
	        
	        
		    
		    
		    ptab =  new Phrase(  boldConf.format("وزارة العدل ") ,boldfontLabelTop);
		    ctab = new PdfPCell(ptab);
		    ctab.setHorizontalAlignment(Element.ALIGN_RIGHT);
		    ctab.setBorder(0);
		    ctab.setPaddingRight(36f); 
		     tab.addCell(ctab);
		    
		    
		     ptab =  new Phrase(  boldConf.format("الهيئة العامة للسجون والإصلاح ") ,boldfontLabelTop);
		     ctab = new PdfPCell(ptab);
		     ctab.setHorizontalAlignment(Element.ALIGN_RIGHT);
		     ctab.setBorder(0);
		     ctab.setPaddingRight(10f); 
		     tab.addCell(ctab);
		    
		     
		     ptab =  new Phrase(  boldConf.format("المدرسة الوطنية للسجون والإصلاح") ,boldfontLabelTop);
		     ctab = new PdfPCell(ptab);
		     ctab.setHorizontalAlignment(Element.ALIGN_RIGHT);
		     ctab.setBorder(0);
		     tab.addCell(ctab);
		    
		    
		    
		    
		    
		    
	        PdfPTable tableTop = new PdfPTable(3);
		    tableTop.setWidthPercentage(100);
		        
		        
		        Phrase p1Top;
		        PdfPCell c1Top;
		         
//		        PdfPCell spaceCellTop = new PdfPCell(new Phrase("  "));
//		        spaceCellTop.setBorder(0);
		      
//		       ---------------  nom --------------------
		        
		        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/uuuu");
		        LocalDate localDate = LocalDate.now();
		        
		         p1Top =  new Phrase( boldConf.format(dtf.format(localDate))+" "+boldConf.format("تونس في") ,boldfontLabelTop);
			     c1Top = new PdfPCell(p1Top);
			     c1Top.setHorizontalAlignment(Element.ALIGN_LEFT);
			     c1Top.setBorder(0);
			     tableTop.addCell(c1Top);
			  
			     
			     URL resource = EleveExporterPDF.class.getResource("/images/cgpr.png");
			        
			     Image image = Image.getInstance(resource);
//		          image.setAbsolutePosition(237f, 750f);
		          image.scaleAbsolute(70f,70f);
		          c1Top = new PdfPCell(image);
				     c1Top.setHorizontalAlignment(Element.ALIGN_CENTER);
				     
				     c1Top.setBorder(0);;
				     
				     tableTop.addCell(c1Top);
				  
				     

			  
				     c1Top = new PdfPCell(tab);
				     c1Top.setHorizontalAlignment(Element.ALIGN_RIGHT);
				     c1Top.setBorder(0);
				     tableTop.addCell(c1Top);
		      
				     tableTop.setSpacingAfter(20f);
			   
	        
		    //Titre     
		   Font boldfontTitle = boldConf.getFontForArabic(30);
		   Font boldfontLabel = boldConf.getFontForArabic(16);
		  
           PdfPTable tTitre = new PdfPTable(1);	   
      
	       Phrase pTitre =  new Phrase(boldConf.format("بــــطاقة إرشــادات" ),boldfontTitle);
	       PdfPCell cTitre = new PdfPCell(pTitre);
	       cTitre.setPaddingBottom(20f); 
	     
	       
	       cTitre.setBackgroundColor(new BaseColor(210, 210, 210));
	       cTitre.setBorderColor(BaseColor.BLACK);
	      
	      
	       cTitre.setHorizontalAlignment(Element.ALIGN_CENTER);
	       
	      
	       tTitre.addCell(cTitre);
	      // tTitre.setSpacingAfter(30f);
	       tTitre.setWidthPercentage(60);
	       
	       if(eleve.getImg() !=null) {
	    	  
	    	     final String base64Data = new String(Base64.encodeBytes(eleve.getImg()));
				  Image ima = Image.getInstance(Base64.decode(base64Data));
	 	          ima.setAbsolutePosition(50f, 559f);
		          ima.scaleAbsolute(90f,105f);
		          
		          ima.setBorder(Rectangle.BOX);
		          ima.setBorderColor(BaseColor.BLACK);
		          ima.setBorderWidth(1f);
		         	          document.add(ima);
			  }
//			   tTitre.addCell(ima);
		       
		     //  tTitre.setSpacingAfter(30f);
		       
	       
	       //arre    
		   Font boldfontinfo = boldConf.getFontForArabic(16);
		   float itemInfotableInspecteurColWidth[] = {30,30 };
		   PdfPTable tInfo = new PdfPTable(itemInfotableInspecteurColWidth);	   
	         
		   tInfo.setWidthPercentage(60);
		
	        Phrase p1;
	        PdfPCell c1;
	        
	       /* ---------------  info --------------------*/
	   
		     p1 =  new Phrase(boldConf.format( eleve.getNumDossierRecrueEl()+""),boldfontLabelAmiriinfo);
		     c1 = new PdfPCell(p1);
		     c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		    // c1.setBorder(0);
		     //c1.setColspan(65);
		     c1.setBorderColor(BaseColor.BLACK);
		    // c1.setBorderColor(BaseColor.BLACK);
		     tInfo.addCell(c1);
		    /* p1 =  new Phrase(  boldConf.format(":") ,boldfontLabelAmiriinfo);
		     c1 = new PdfPCell(p1);
		     c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		     c1.setBorder(0);
		     c1.setColspan(5);
		    
		     
		     tInfo.addCell(c1);*/
	         
	         p1 =  new Phrase(  boldConf.format("رقم الملف") ,boldfontLabelAmiriinfo);
		     c1 = new PdfPCell(p1);
		     c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		    // c1.setBorder(0);
		     
		    // c1.setColspan(30);
		       c1.setBorderColor(BaseColor.BLACK);
		     
		     tInfo.addCell(c1);
		     p1 =  new Phrase(boldConf.format( eleve.getCinEl()+""),boldfontLabelAmiriinfo);
		     c1 = new PdfPCell(p1);
		     c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		    // c1.setBorder(0);
		    // c1.setColspan(65);
		     c1.setBorderColor(BaseColor.BLACK);
		     tInfo.addCell(c1);
		  /*
		     p1 =  new Phrase(  boldConf.format(":") ,boldfontLabelAmiriinfo);
		     c1 = new PdfPCell(p1);
		     c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		     c1.setBorder(0);
		     c1.setColspan(5);
		   
		     
		     tInfo.addCell(c1);
		     */
	         p1 =  new Phrase(  boldConf.format("ر.ب.ت.و") ,boldfontLabelAmiriinfo);
		     c1 = new PdfPCell(p1);
		     c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		    // c1.setBorder(0);
		     //c1.setColspan(30);
		     c1.setBorderColor(BaseColor.BLACK);
		     
		     tInfo.addCell(c1);
		     p1 =  new Phrase(boldConf.format( eleve.getGrade().getLibelle_grade()+""),boldfontLabelAmiriinfo);
		     c1 = new PdfPCell(p1);
		     c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		    // c1.setBorder(0);
		    // c1.setColspan(65);
		     c1.setBorderColor(BaseColor.BLACK); 
		     tInfo.addCell(c1);
		  
		    /* p1 =  new Phrase(  boldConf.format(":") ,boldfontLabelAmiriinfo);
		     c1 = new PdfPCell(p1);
		     c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		     c1.setBorder(0);
		     c1.setColspan(5);*
		    
		     
		     tInfo.addCell(c1);*/
	         p1 =  new Phrase(  boldConf.format("الرتبة") ,boldfontLabelAmiriinfo);
		     c1 = new PdfPCell(p1);
		     c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		    // c1.setBorder(0);
		  //   c1.setColspan(30);
		     c1.setBorderColor(BaseColor.BLACK);
		     tInfo.addCell(c1);
		    
		       /* ---------------  session --------------------*/
		     p1 =  new Phrase(boldConf.format( eleve.getSession().getNumSession()+""),boldfontLabelAmiriinfo);
		     c1 = new PdfPCell(p1);
		     c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		    // c1.setBorder(0);
		    // c1.setColspan(65);
		     c1.setBorderColor(BaseColor.BLACK);
		     tInfo.addCell(c1);
		  
		    /* p1 =  new Phrase(  boldConf.format(":") ,boldfontLabelAmiriinfo);
		     c1 = new PdfPCell(p1);
		     c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		     c1.setBorder(0);
		     c1.setColspan(5);
		    
		     
		     tInfo.addCell(c1);*/
	         p1 =  new Phrase(  boldConf.format("الدورة") ,boldfontLabelAmiriinfo);
		     c1 = new PdfPCell(p1);
		     c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		   //  c1.setBorder(0);
		    // c1.setColspan(30);
		     c1.setBorderColor(BaseColor.BLACK);
		     tInfo.addCell(c1);
		      /* ---------------  group --------------------*/
		     p1 =  new Phrase(boldConf.format(eleve.getGroup().getNomGroup()),boldfontLabelAmiriinfo);
		     c1 = new PdfPCell(p1);
		     c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		    // c1.setBorder(0);
		   //  c1.setColspan(65);
		     c1.setBorderColor(BaseColor.BLACK);
		     tInfo.addCell(c1);
		  
		   /*  p1 =  new Phrase(  boldConf.format(":") ,boldfontLabelAmiriinfo);
		     c1 = new PdfPCell(p1);
		     c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		     c1.setBorder(0);
		     c1.setColspan(5);
		    
		     
		     tInfo.addCell(c1);*/
	         p1 =  new Phrase(  boldConf.format("الفوج") ,boldfontLabelAmiriinfo);
		     c1 = new PdfPCell(p1);
		     c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		   //  c1.setBorder(0);
		 //    c1.setColspan(30);
		     c1.setBorderColor(BaseColor.BLACK);
		     tInfo.addCell(c1);
		     /* ---------------  company --------------------*/
		     p1 =  new Phrase(boldConf.format(eleve.getCompany().getNumCompany()+""),boldfontLabelAmiriinfo);
		     c1 = new PdfPCell(p1);
		     c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		    // c1.setBorder(0);
		    // c1.setColspan(65);
		      
		     tInfo.addCell(c1);
		  
		   /*  p1 =  new Phrase(  boldConf.format(":") ,boldfontLabelAmiriinfo);
		     c1 = new PdfPCell(p1);
		     c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		     c1.setBorder(0);
		     c1.setColspan(5);
		    
		     
		     tInfo.addCell(c1);*/
	         p1 =  new Phrase(  boldConf.format("السرية") ,boldfontLabelAmiriinfo);
		     c1 = new PdfPCell(p1);
		     c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		    // c1.setBorder(0);
		    // c1.setColspan(30);
		     c1.setBorderColor(BaseColor.BLACK);
		     tInfo.addCell(c1);
		     /* ---------------  section --------------------*/
		     p1 =  new Phrase(boldConf.format(eleve.getSection().getNumSection()+""),boldfontLabelAmiriinfo);
		     c1 = new PdfPCell(p1);
		     c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		    // c1.setBorder(0);
		 //    c1.setColspan(65);
		     c1.setBorderColor(BaseColor.BLACK);
		     tInfo.addCell(c1);
		  
		   /*  p1 =  new Phrase(  boldConf.format(":") ,boldfontLabelAmiriinfo);
		     c1 = new PdfPCell(p1);
		     c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		     c1.setBorder(0);
		     c1.setColspan(5);
		    
		     
		     tInfo.addCell(c1);*/
	         p1 =  new Phrase(  boldConf.format("الفصيل") ,boldfontLabelAmiriinfo);
		     c1 = new PdfPCell(p1);
		     c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		  //   c1.setBorder(0);
		    // c1.setColspan(30);
		     c1.setBorderColor(BaseColor.BLACK);
		     tInfo.addCell(c1);
		     tInfo.setSpacingAfter(30f);
		     PdfPTable table = new PdfPTable(100);
		     table.setWidthPercentage(100);
		    
//		       ---------------  nom --------------------
		      
		         p1 =  new Phrase(boldConf.format( eleve.getPrenomEl()+" بن "+ eleve.getIdentitePereEl() +"  "+ eleve.getNomEl()),boldfontLabelAmiriDate);
			     c1 = new PdfPCell(p1);
			     c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
			     c1.setBorder(0);
			     c1.setColspan(65);  
			     c1.setPaddingBottom(7f); 
			     table.addCell(c1); 
			  
		         
			     p1 =  new Phrase(  boldConf.format(":") ,boldfontLabel);
			     c1 = new PdfPCell(p1);
			     c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			     c1.setBorder(0);
			     c1.setColspan(5);
			    
			     
			     table.addCell(c1);
			     
		         p1 =  new Phrase(  boldConf.format("الهـــــــــــــــــــــــــــــــــــوية") ,boldfontLabel);
			     c1 = new PdfPCell(p1);
			     c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
			     c1.setBorder(0);
			     c1.setColspan(30);
			    
			     c1.setPaddingBottom(7f); 
			     table.addCell(c1);
			                                       
			     
//			       ---------------  mere --------------------  
			     
		         p1 =  new Phrase(boldConf.format( eleve.getIdentiteMereEl()),boldfontLabelAmiriDate);
		         c1 = new PdfPCell(p1);
		         c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		         c1.setBorder(0);
		         c1.setColspan(65);
		         c1.setPaddingBottom(7f); 
		         table.addCell(c1);
			     
		         
		         p1 =  new Phrase(  boldConf.format(":") ,boldfontLabel);
			     c1 = new PdfPCell(p1);
			     c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			     c1.setBorder(0);
			     c1.setColspan(5);
			    
			     table.addCell(c1);
			     
			     
		         p1 =  new Phrase(boldConf.format("إبــــــــــــــــــــــــــــــــــــــن " ),boldfontLabel);
		         c1 = new PdfPCell(p1);
		         c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		         c1.setBorder(0);
		         c1.setColspan(30);
		         c1.setPaddingBottom(7f); 
		         table.addCell(c1);
		          
			 

//			       ---------------   Lieu et lieu --------------------	    
		       //  "بــــــــــــــــــــ"+ eleve.getLieuNaissanceEl() )+" "+
		        
		         p1 =  //new Phrase(boldConf.format("بــــــــــــــــــــ"+ eleve.getLieuNaissanceEl()+" "+eleve.getDatenaissanceEl().toString()),boldfontLabelTop);
		         new Phrase( boldConf.format("بــــــــــــــــــــ"+ eleve.getLieuNaissanceEl()) + boldConf.format(eleve.getDatenaissanceEl().toString()+" ") ,boldfontLabelTop);
		         c1 = new PdfPCell(p1);
		         c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		         c1.setBorder(0);
		         c1.setColspan(65);
		         c1.setPaddingBottom(7f); 
		         table.addCell(c1);
		         
		         p1 =  new Phrase(  boldConf.format(":") ,boldfontLabel);
			     c1 = new PdfPCell(p1);
			     c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			     c1.setBorder(0);
			     c1.setColspan(5);
			    
			     table.addCell(c1);
			     
		         
		         p1 =  new Phrase(boldConf.format("تــــــاريخ الـولادة ومكانهـــــا" ),boldfontLabel);
		         c1 = new PdfPCell(p1);
		         c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		         c1.setBorder(0);
		         c1.setColspan(30);
		         c1.setPaddingBottom(7f); 
		         table.addCell(c1);
		          
		         
//			       --------------- adress --------------------      
		         
		         p1 =  new Phrase(boldConf.format(", "+ eleve.getCodePostaleEl() )+boldConf.format( eleve.getGouvernorat().getLibelle_gouvernorat()+", "+ eleve.getRueEl()),boldfontLabelAmiriDate);
		         c1 = new PdfPCell(p1);
		         c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		         c1.setBorder(0);
		         c1.setColspan(65);
		         c1.setPaddingBottom(7f); 
		         table.addCell(c1);
		         
		         
		         p1 =  new Phrase(  boldConf.format(":") ,boldfontLabel);
			     c1 = new PdfPCell(p1);
			     c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			     c1.setBorder(0);
			     c1.setColspan(5);
			    
			     table.addCell(c1);
			     
		         p1 =  new Phrase(boldConf.format("   العنوان" ),boldfontLabel);
		         c1 = new PdfPCell(p1);
		         c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		         c1.setBorder(0);
		         c1.setColspan(30);
		         c1.setPaddingBottom(7f); 
		         table.addCell(c1);	 
		         
		         p1 =  new Phrase(boldConf.format( eleve.getZonePoliceEl() ),boldfontLabelAmiriDate);
		         c1 = new PdfPCell(p1);
		         c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		         c1.setBorder(0);
		         c1.setColspan(65);
		         c1.setPaddingBottom(7f); 
		         table.addCell(c1);
		         
		         
		         p1 =  new Phrase(  boldConf.format(":") ,boldfontLabel);
			     c1 = new PdfPCell(p1);
			     c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			     c1.setBorder(0);
			     c1.setColspan(5);
			    
			     table.addCell(c1);
			     
		         p1 =  new Phrase(boldConf.format("  منطقة الإمن أو الحرس" ),boldfontLabel);
		         c1 = new PdfPCell(p1);
		         c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		         c1.setBorder(0);
		         c1.setColspan(30);
		         c1.setPaddingBottom(7f); 
		         table.addCell(c1);	 
		         
		         p1 =  new Phrase(boldConf.format( eleve.getCentralPoliceEl() ),boldfontLabelAmiriDate);
		         c1 = new PdfPCell(p1);
		         c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		         c1.setBorder(0);
		         c1.setColspan(65);
		         c1.setPaddingBottom(7f); 
		         table.addCell(c1);
		         
		         
		         p1 =  new Phrase(  boldConf.format(":") ,boldfontLabel);
			     c1 = new PdfPCell(p1);
			     c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			     c1.setBorder(0);
			     c1.setColspan(5);
			    
			     table.addCell(c1);
			     
		         p1 =  new Phrase(boldConf.format("  مركز الإمن أو الحرس" ),boldfontLabel);
		         c1 = new PdfPCell(p1);
		         c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		         c1.setBorder(0);
		         c1.setColspan(30);
		         c1.setPaddingBottom(7f); 
		         table.addCell(c1);	 
		         
//			 //      --------------- niveau edu --------------------      
		         
		         p1 =  new Phrase(boldConf.format( eleve.getNivScolaireEl() ),boldfontLabelAmiriDate);
		         c1 = new PdfPCell(p1);
		         c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		         c1.setBorder(0);
		         c1.setColspan(65);
		         c1.setPaddingBottom(7f); 
		         table.addCell(c1);
		         
		         p1 =  new Phrase(  boldConf.format(":") ,boldfontLabel);
			     c1 = new PdfPCell(p1);
			     c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			     c1.setBorder(0);
			     c1.setColspan(5);
			    
			     table.addCell(c1);
			     
		         
		         p1 =  new Phrase(boldConf.format("المستــوى التعليمـــــــــــي" ),boldfontLabel);
		         c1 = new PdfPCell(p1);
		         c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		         c1.setBorder(0);
		         c1.setColspan(30);
		         c1.setPaddingBottom(7f); 
		         table.addCell(c1);
 //      --------------- spécialité edu --------------------      
		         
		         Specialite specialite =eleve.getSpecialite();
		         String s="";
		         if(specialite == null )
		         {
		        	  s ="";
		         }else {
		        	 s=specialite.getLibelle_specialite();
		         }
		         p1 =  new Phrase(boldConf.format( s ),boldfontLabelAmiriDate);
		         c1 = new PdfPCell(p1);
		         c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		         c1.setBorder(0);
		         c1.setColspan(65);
		         c1.setPaddingBottom(7f); 
		         table.addCell(c1);
		         
		         p1 =  new Phrase(  boldConf.format(":") ,boldfontLabel);
			     c1 = new PdfPCell(p1);
			     c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			     c1.setBorder(0);
			     c1.setColspan(5);
			    
			     table.addCell(c1);
			     
		         
		         p1 =  new Phrase(boldConf.format(" الإختصاص" ),boldfontLabel);
		         c1 = new PdfPCell(p1);
		         c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		         c1.setBorder(0);
		         c1.setColspan(30);
		         c1.setPaddingBottom(7f); 
		         table.addCell(c1);
		         	
		         p1 =  new Phrase(boldConf.format( eleve.getDiplomeEl() ),boldfontLabelAmiriDate);
		         c1 = new PdfPCell(p1);
		         c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		         c1.setBorder(0);
		         c1.setColspan(65);
		         c1.setPaddingBottom(7f); 
		         table.addCell(c1);
		         
		         p1 =  new Phrase(  boldConf.format(":") ,boldfontLabel);
			     c1 = new PdfPCell(p1);
			     c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			     c1.setBorder(0);
			     c1.setColspan(5);
			    
			     table.addCell(c1);
			     
		         
		         p1 =  new Phrase(boldConf.format("الشهادة العلمية" ),boldfontLabel);
		         c1 = new PdfPCell(p1);
		         c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		         c1.setBorder(0);
		         c1.setColspan(30);
		         c1.setPaddingBottom(7f); 
		         table.addCell(c1);
		         
		         p1 =  new Phrase(boldConf.format( eleve.getEtatMilitaireEl() ),boldfontLabelAmiriDate);
		         c1 = new PdfPCell(p1);
		         c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		         c1.setBorder(0);
		         c1.setColspan(65);
		         c1.setPaddingBottom(7f); 
		         table.addCell(c1);
		         
		         p1 =  new Phrase(  boldConf.format(":") ,boldfontLabel);
			     c1 = new PdfPCell(p1);
			     c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			     c1.setBorder(0);
			     c1.setColspan(5);
			    
			     table.addCell(c1);
			     
		         
		         p1 =  new Phrase(boldConf.format("الخدمة العسكرية" ),boldfontLabel);
		         c1 = new PdfPCell(p1);
		         c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		         c1.setBorder(0);
		         c1.setColspan(30);
		         c1.setPaddingBottom(7f); 
		         table.addCell(c1);
		         
		         p1 =  new Phrase(boldConf.format( eleve.getEtatcivil().getLibelle_etatcivil() ),boldfontLabelAmiriDate);
		         c1 = new PdfPCell(p1);
		         c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		         c1.setBorder(0);
		         c1.setColspan(65);
		         c1.setPaddingBottom(7f); 
		         table.addCell(c1);
		         
		         p1 =  new Phrase(  boldConf.format(":") ,boldfontLabel);
			     c1 = new PdfPCell(p1);
			     c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			     c1.setBorder(0);
			     c1.setColspan(5);
			    
			     table.addCell(c1);
			     
		         
		         p1 =  new Phrase(boldConf.format("الحالة المدنية" ),boldfontLabel);
		         c1 = new PdfPCell(p1);
		         c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		         c1.setBorder(0);
		         c1.setColspan(30);
		         c1.setPaddingBottom(7f); 
		         table.addCell(c1);
		         
		         p1 =  new Phrase(boldConf.format( eleve.getPassionEl() ),boldfontLabelAmiriDate);
		         c1 = new PdfPCell(p1);
		         c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		         c1.setBorder(0);
		         c1.setColspan(65);
		         c1.setPaddingBottom(7f); 
		         table.addCell(c1);
		         
		         p1 =  new Phrase(  boldConf.format(":") ,boldfontLabel);
			     c1 = new PdfPCell(p1);
			     c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			     c1.setBorder(0);
			     c1.setColspan(5);
			    
			     table.addCell(c1);
			     
		         
		         p1 =  new Phrase(boldConf.format("الهواية " ),boldfontLabel);
		         c1 = new PdfPCell(p1);
		         c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		         c1.setBorder(0);
		         c1.setColspan(30);
		         c1.setPaddingBottom(7f); 
		         table.addCell(c1);
		         
		         p1 =  new Phrase(boldConf.format( eleve.getActiviteSportifEl()),boldfontLabelAmiriDate);
		         c1 = new PdfPCell(p1);
		         c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		         c1.setBorder(0);
		         c1.setColspan(65);
		         c1.setPaddingBottom(7f); 
		         table.addCell(c1);
		         
		         p1 =  new Phrase(  boldConf.format(":") ,boldfontLabel);
			     c1 = new PdfPCell(p1);
			     c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			     c1.setBorder(0);
			     c1.setColspan(5);
			    
			     table.addCell(c1);
			     
		         
		         p1 =  new Phrase(boldConf.format("الأنشطة الرياضية " ),boldfontLabel);
		         c1 = new PdfPCell(p1);
		         c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		         c1.setBorder(0);
		         c1.setColspan(30);
		         c1.setPaddingBottom(7f); 
		         table.addCell(c1);
		         
		         p1 =  new Phrase(boldConf.format( eleve.getTelEl()),boldfontLabelAmiriDate);
		         c1 = new PdfPCell(p1);
		         c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		         c1.setBorder(0);
		         c1.setColspan(65);
		         c1.setPaddingBottom(7f); 
		         table.addCell(c1);
		         
		         p1 =  new Phrase(  boldConf.format(":") ,boldfontLabel);
			     c1 = new PdfPCell(p1);
			     c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			     c1.setBorder(0);
			     c1.setColspan(5);
			    
			     table.addCell(c1);
			     
		         
		         p1 =  new Phrase(boldConf.format("رقم الهاتف  " ),boldfontLabel);
		         c1 = new PdfPCell(p1);
		         c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		         c1.setBorder(0);
		         c1.setColspan(30);
		         c1.setPaddingBottom(7f); 
		         table.addCell(c1);
		         List<RepoEleve> listR= repoEleveRepository.findAllSonByMother(eleve.getId());
		         int countR =  listR.size();
		         String resR=countR>9 ? countR+"":"0"+countR;
		         p1 =  new Phrase(boldConf.format(resR),boldfontLabelAmiriDate);
		         c1 = new PdfPCell(p1);
		         c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		         c1.setBorder(0);
		         c1.setColspan(65);
		         c1.setPaddingBottom(7f); 
		         table.addCell(c1);
		         
		         p1 =  new Phrase(  boldConf.format(":") ,boldfontLabel);
			     c1 = new PdfPCell(p1);
			     c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			     c1.setBorder(0);
			     c1.setColspan(5);
			    
			     table.addCell(c1);
			     
		         
		         p1 =  new Phrase(boldConf.format(" راحة طبية" ),boldfontLabel);
		         c1 = new PdfPCell(p1);
		         c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		         c1.setBorder(0);
		         c1.setColspan(30);
		         c1.setPaddingBottom(7f); 
		         table.addCell(c1);
		     
		         List<ConsultationEleve> listConsultation= this.consultationEleveRepository.findAllSonByMother(eleve.getId());
		         int countC =  listConsultation.size();
		         String resC=countC>9 ? countC+"":"0"+countC;
		         p1 =  new Phrase(boldConf.format( resC),boldfontLabelAmiriDate);
		         c1 = new PdfPCell(p1);
		         c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		         c1.setBorder(0);
		         c1.setColspan(65);
		         c1.setPaddingBottom(7f); 
		         table.addCell(c1);
		         
		         p1 =  new Phrase(  boldConf.format(":") ,boldfontLabel);
			     c1 = new PdfPCell(p1);
			     c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			     c1.setBorder(0);
			     c1.setColspan(5);
			    
			     table.addCell(c1);
			     
		         
		         p1 =  new Phrase(boldConf.format("العيادات الطبية" ),boldfontLabel);
		         c1 = new PdfPCell(p1);
		         c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		         c1.setBorder(0);
		         c1.setColspan(30);
		         c1.setPaddingBottom(7f); 
		         table.addCell(c1);
		         
		         
		         List<PenaliteEleve> listPenaliteEleve= this.penaliteEleveRepository.findAllSonByMother(eleve.getId());
		         int countP=  listPenaliteEleve.size();
		         String resP=countP>9 ? countP+"":"0"+countP;
		         p1 =  new Phrase(boldConf.format( resP),boldfontLabelAmiriDate);
		         c1 = new PdfPCell(p1);
		         c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		         c1.setBorder(0);
		         c1.setColspan(65);
		         c1.setPaddingBottom(7f); 
		         table.addCell(c1);
		         
		         p1 =  new Phrase(  boldConf.format(":") ,boldfontLabel);
			     c1 = new PdfPCell(p1);
			     c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			     c1.setBorder(0);
			     c1.setColspan(5);
			    
			     table.addCell(c1);
			     
		         
		         p1 =  new Phrase(boldConf.format("العقوبات" ),boldfontLabel);
		         c1 = new PdfPCell(p1);
		         c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		         c1.setBorder(0);
		         c1.setColspan(30);
		         c1.setPaddingBottom(7f); 
		         table.addCell(c1);
	        /*------------------------------Add Element to Document  And Close it ----------------------------------------*/
	        document.add(tableTop);
	        document.add(tTitre);
	        document.add(tInfo);
	        document.add(table);
			document.close();

			return new ByteArrayInputStream(out.toByteArray());

	}
}
