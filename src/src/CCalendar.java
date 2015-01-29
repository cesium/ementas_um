package src;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventDateTime;
import java.awt.Desktop;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import view.MainMenuSwing;

public class CCalendar {

	private String CLIENT_ID;
	private String CLIENT_SECRET;
        
	private final String REDIRECT_URL = "urn:ietf:wg:oauth:2.0:oob";
        
	private final String SCOPE ="https://www.googleapis.com/auth/calendar";
	private final String APP_NAME="MealCalendar";
	
        //Calendar URLs
	private String almocoRampaA;
        private String jantarRampaA;
        
        private String almocoVegetariano;
        private String jantarVegetariano;
        
        private String almocoRampaB;
        private String jantarRampaB;
        
	private Calendar service ;
	
	private String authorizationUrl;
	private String code;
	
	public CCalendar(String id, String secret, String ara, String jra, String av, String jv, String arb, String jrb){
            //Removes whitespaces just in case
            CLIENT_ID = id.replaceAll("\\s","");
            CLIENT_SECRET = secret.replaceAll("\\s","");
            
            almocoRampaA = ara.replaceAll("\\s","");
            jantarRampaA = jra.replaceAll("\\s","");
            
            almocoVegetariano = av.replaceAll("\\s","");
            jantarVegetariano = jv.replaceAll("\\s","");
            
            almocoRampaB = arb.replaceAll("\\s","");
            jantarRampaB = jrb.replaceAll("\\s","");
        }
	
	/**
	 * Start the service to get the token; Close when close the application. 
	 * @throws GeneralSecurityException
	 * @throws IOException
	 */
	public void setUp(final MainMenuSwing frame) throws GeneralSecurityException, IOException, CanceledOptionException{
		
		HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
		JacksonFactory jsonFactory = JacksonFactory.getDefaultInstance();

		GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow(
				httpTransport, jsonFactory, CLIENT_ID, CLIENT_SECRET, Collections.singleton(SCOPE));
		
		// Step 1: Authorize
		String authorizationUrl = flow.newAuthorizationUrl().setRedirectUri(REDIRECT_URL).build();
                
                //Creating a clickable link
                JEditorPane jep = new JEditorPane();
                jep.setContentType("text/html");//set content as html
                jep.setText("Insira o código obtido na <a href='" + authorizationUrl + "'>página de autenticação</a>.");
                
                jep.setEditable(false);
                jep.setOpaque(false);
                
                jep.addHyperlinkListener(new HyperlinkListener() {
                    @Override
                    public void hyperlinkUpdate(HyperlinkEvent hle) {
                        if (HyperlinkEvent.EventType.ACTIVATED.equals(hle.getEventType())) {
                            Desktop desktop = Desktop.getDesktop();
                            try {
                                desktop.browse(hle.getURL().toURI());
                            } catch (Exception ex) {
                                frame.addMessage("Erro de acesso");
                            }
                        }
                    }
                    });
                
                
                // Point or redirect your user to the authorizationUrl and get the authorization code
                String code = "";
                while(code != null && code.isEmpty()){
                    code = JOptionPane.showInputDialog(frame,jep, "Autenticação", JOptionPane.INFORMATION_MESSAGE);
                }
                if( code == null)
                    throw new CanceledOptionException();
                
		// End of Step 1

		// Step 2: Exchange
		GoogleTokenResponse response = flow.newTokenRequest(code).setRedirectUri(REDIRECT_URL)
		        .execute();
		    // End of Step 2

		Credential credential = new GoogleCredential.Builder()
		        .setTransport(httpTransport)
		        .setJsonFactory(jsonFactory)
		        .setClientSecrets(CLIENT_ID, CLIENT_SECRET)
		        .build().setFromTokenResponse(response);

		service = new Calendar.Builder(httpTransport, jsonFactory, credential)
		        .setApplicationName("MealCalendar").build();
	}

	
	
	//add list of meals to google calendar
	public void commitListMeal(ArrayList<Meal> lmeal, MainMenuSwing frame, int type) throws IOException{
		
		
		for (Meal m :lmeal )
		{
			Event event = new Event();
                        event.setSummary(m.getDescription());
                        
			event.setLocation("Universidade do minho");
		
		
			// date type
			DateTime start = DateTime.parseRfc3339(m.getYear()+ "-" + m.getMonth()+ "-" +m.getDay()+ m.getMealStartTime() + "Z");
			DateTime end = DateTime.parseRfc3339(m.getYear()+ "-" + m.getMonth()+ "-" +m.getDay()+ m.getMealEndTime()+"Z");
			event.setStart(new EventDateTime().setDateTime(start).setTimeZone("Europe/Lisbon"));
			event.setEnd(new EventDateTime().setDateTime(end).setTimeZone("Europe/Lisbon"));
			event.setRecurrence(Arrays.asList("RRULE:FREQ=WEEKLY;UNTIL=20110701T170000Z"));

			Event recurringEvent = null;
                        
                        //Considers the meal (lunch/dinner) and the type of menu.
			if(m.is_lunch()){
                            switch(type){
                                case 0:
                                    recurringEvent = service.events().insert(this.almocoRampaA, event).execute();
                                    frame.addMessage("Almoço Normal adicionado: dia " +m.getDay() );
                                    break;
                                case 1:
                                    recurringEvent = service.events().insert(this.almocoVegetariano, event).execute();
                                    frame.addMessage("Almoço Vegetariano adicionado: dia " +m.getDay() );
                                    break;
                                case 2:
                                    recurringEvent = service.events().insert(this.almocoRampaB, event).execute();
                                    frame.addMessage("Almoço Rampa B adicionado: dia " +m.getDay() );
                                    break;
                            } 
                        }
                        else{
                            switch(type){
                                case 0:
                                    recurringEvent = service.events().insert(this.jantarRampaA, event).execute();
                                    frame.addMessage("Jantar Normal adicionado: dia " +m.getDay() );
                                    break;
                                case 1:
                                    recurringEvent = service.events().insert(this.jantarVegetariano, event).execute();
                                    frame.addMessage("Jantar Vegetariano adicionado: dia " +m.getDay() );
                                    break;
                                case 2:
                                    recurringEvent = service.events().insert(this.jantarRampaB, event).execute();
                                    frame.addMessage("Jantar Rampa B adicionado: dia " +m.getDay() );
                                    break;
                            }
                        }
		}		
	} 	
}
