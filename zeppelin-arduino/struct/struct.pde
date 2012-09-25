// Engine structor:
typedef struct {
  int     pinID;
  boolean status;
  byte    keyCode;
} engine;

// Globals:
engine engineArray[2];


void setup() {
  engineArray[0] = {11, false, 50};
  engineArray[1] = {10, false, 51};
  
  for(int i = 0; i < sizeof(engineArray); i++) {
    pinMode(engineArray[i].pinID, OUTPUT);
  }

  // Setup the COM port:
  Serial.begin(115200);
  Serial.println("Arduino COM port up and running.");
}


void loop() {
  for(int i = 0; i < sizeof(engineArray); i++) {
    digitalWrite(engineArray[i].pinID, HIGH);
  } 
  delay(1000); 
}
