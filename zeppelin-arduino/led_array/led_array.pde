int ledArray[]        = {10, 9, 4, 5};
int ledArrayStatus[]  = {false, false, false, false};
int ledArrayKey[]     = {50, 51, 52, 53};
//                        2   3   4   5

void setup() {
  for(int i = 0; i < sizeof(ledArray); i++) {
    pinMode(ledArray[i], OUTPUT);  
  }
  //pinMode(2, OUTPUT);  
  
    
  Serial.begin(115200);
  Serial.println("Arduino COM port up and running.");
}

void loop() {  
   if(Serial.available() > 0) {
     int input = Serial.read();
     boolean isKnownKey = false; 
     
     for(int i = 0; i < sizeof(ledArray)-1; i++) {
       if(ledArrayKey[i] == input) {
         isKnownKey = true;
         
         if(ledArrayStatus[i] == false) {
           digitalWrite(ledArray[i], 100);  
           ledArrayStatus[i] = true;
         } else {
           ledArrayStatus[i] = false;
           digitalWrite(ledArray[i], LOW);  
         }
         
         Serial.println("success "); 
         //Serial.println(input);
       }
     }
     
     if(!isKnownKey) {
       Serial.print("Unknown key "); 
       Serial.println(input);
     }
     //Serial.print("G"); 
     //delay(0);
   }
}


