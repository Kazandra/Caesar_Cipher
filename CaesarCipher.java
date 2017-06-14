/**
 * @author Kazandra
 * 
 * 
 * 
 */

import java.util.Scanner;
import java.io.*;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;


	//use of encapsulation
	public class CaesarCipher {
		private String line;
		public String getLine() {
			return line;
		}
		public void setLine(String phrase) {
			line = phrase;
		}
		
	
		//use of inheritance
		static class encryption {
			public static String alphabet;		
			}
		
		class cipher extends encryption { 
					
			static final String alphabet = "abcdefghijklmnopqrstuvwxyz";
		}
		
		//encrypt method
		public static String encrypt(String phrase,int shiftKey)
	     {
	           String Alphabet = cipher.alphabet;
	           
	           //to check if alphabet is printing correctly
	           //System.out.println(Alphabet);
	           
	           phrase = phrase.toLowerCase();
	           String cipherText="";
	           //goes through phrase, removes any errors spaces could cause 
	           for(int i = 0; i < phrase.length();)
		           {
			           if(phrase.charAt(i) == ' ') {
			           cipherText += phrase.charAt(i);
			           i++;
			           }
		           
		           else {
		           
			           int charPosition = Alphabet.indexOf(phrase.charAt(i));
			           //26 positions in alphabet, it  creates a new index (shift) based on shiftkey
			           int keyValue = (shiftKey + charPosition) % 26;
			           //replaces old position index with new position index
			           char replaceVal = Alphabet.charAt(keyValue);
			           
			           cipherText += replaceVal;
			           i++;
			           }
			           }
	         
	           return cipherText;
	           }
		
		
		
		
		//the decrypt method
	     public static String decoded(String phrase,int shiftKey)
	     {
	           String Alphabet = cipher.alphabet;

	           phrase = phrase.toLowerCase();
	           String cipherText="";
	           //goes through phrase, ignoring empty spaces by moving "i" along
	           for(int i = 0; i < phrase.length();)
		           {
	        	   
	        	   //removes any errors that spaces may cause in phrase
		           int charPosition = Alphabet.indexOf(phrase.charAt(i));
		           if(phrase.charAt(i) == ' ') {
			           cipherText += phrase.charAt(i);
			           i++;
			           }
		           
		           else {
			           //reverse logic from encryption
			           //uses encryption's "new" alphabet to decrypt
			           int keyValue = (charPosition - shiftKey) % 26;
			           
			           //keeps index within bounds 
			           if (keyValue < 0){
			        	   keyValue = keyValue + 26;
			           } else if (keyValue >= 26){
			        	   keyValue = keyValue - 26;
			           }
			           
		
			          
			           char replaceVal = Alphabet.charAt(keyValue);
			           i++;
			        	   
			           cipherText += replaceVal;
			           
			           }
	           }
			return cipherText;
			}
		

	
	public static void main(String[] args) throws IOException{
		
		//bringing CaesarCipher private variables
		CaesarCipher obj = new CaesarCipher();

			BufferedReader read = new BufferedReader(new FileReader("C:...CaesarCipher/input.txt"));
			try {
			    //StringBuilder sb = new StringBuilder();
			    obj.setLine(read.readLine());
			    System.out.println("Original message: ");
			    
			   
		    	 //prints out message
				    while (obj.getLine() != null) {
					    System.out.println(obj.getLine());
				        //sb.append(obj.getLine());
				        //sb.append(System.lineSeparator());
				        //obj.setLine(read.readLine());
				        break;
				    }
				    
			    Scanner scan = new Scanner(System.in);
				 System.out.println("Encoding key? ");
				 	int key = scan.nextInt();
				 		String encryption = encrypt(obj.getLine(), key).toUpperCase();
				 
				 //prints output in all caps for further encryption
				 System.out.println("Encrypted message: " + encryption);
				 scan.close();
				 	
				 	//writes encryption to a text file
					 try 
						 (Writer writer = new BufferedWriter(new OutputStreamWriter(
					              new FileOutputStream("C:...CaesarCipher/encrypted.txt"), "utf-8"))) {
					   writer.write(encryption);
					   writer.close();}
					   
					   catch (IOException error) {
						      error.printStackTrace();
						}
					   
					   
					   
					   //reads new encryption file
					   BufferedReader EncryptRead = new BufferedReader(new FileReader("C:...CaesarCipher/encrypted.txt"));
						try {
						    //StringBuilder sb = new StringBuilder();
						    obj.setLine(EncryptRead.readLine());
						    System.out.println("Encrypted message from file: ");
						   
					    	 //prints out message
							    while (obj.getLine() != null) {
								    System.out.println(obj.getLine());
							        //sb.append(obj.getLine());
							        //sb.append(System.lineSeparator());
							        //obj.setLine(read.readLine());
							        break;}}
							    
									    finally {
										    read.close();
										    }
						
							    
							 String decode = decoded(obj.getLine(), key).toUpperCase();
							 //prints output in all caps for further encryption
							 System.out.println("Decoded message: " + decode);
							 
										 try 
										 		 //write decoded message to new text file
												 (Writer write = new BufferedWriter(new OutputStreamWriter(
											              new FileOutputStream("C:...CaesarCipher/decoded.txt"), "utf-8"))) {
															   write.write(decode);
															   write.close();
										 							}
										 
																 finally {
																		EncryptRead.close();
																	    }
										 									}
										 
										 
																		 catch (IOException error) {
																		      error.printStackTrace();
																		}
																			}
																				}
					  
					

