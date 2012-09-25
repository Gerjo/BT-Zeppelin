
boolean isLedOn = true;
int      ledPin = 12;

void setup() {
  pinMode(ledPin, OUTPUT); 
  
  Serial.begin(115200);
  
  Serial.println("Starting :)");
}

void loop() { 
  if(Serial.available() > 0) {
    int input = Serial.read(); 
     
    if(input == 50) {
      if(isLedOn) {
        isLedOn = false;
        Serial.println("LED 12 off");
      } else {
         Serial.println("LED 12 is already off");
      }
    } else if(input == 49) {
      if(!isLedOn) {
        isLedOn = true;
        Serial.println("LED 12 on");
      } else {
        Serial.println("LED 12 is already on");
      }
    }
    
  }
  
  if(isLedOn) {
     digitalWrite(ledPin, HIGH);
  } else {
     digitalWrite(ledPin, LOW);
  }
}
