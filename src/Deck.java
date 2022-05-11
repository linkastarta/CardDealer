import java.util.Random;

public class Deck {
    public Card[] cards;
    public Card[] drawn;
    public int Top;
    public int Bot;


    public Deck(){
        this.cards = new Card[52];
        this.drawn = new Card[52];
        this.Top = 0;
        this.Bot = 51;
    }

    public void DeckMaker(){
        for(int i=0; i < 13; i++){
            this.cards[i]=new Card("Club", i+1, i);
        }
        for(int i=0; i < 13; i++){
            this.cards[i+13]=new Card("Spade", i+1, i+13);
        }
        for(int i=0; i < 13; i++){
            this.cards[i+26]=new Card("Hearts", i+1, i+26);
        }
        for(int i=0; i < 13; i++){
            this.cards[i+39]=new Card("Diamond", i+1, i+39);
        }
    }

    public void drawCards(int N){
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < 52; j++) {
                if (this.cards[j].Order == this.Top + i) {
                    this.cards[j].Order = -1;
                }
            }
        }
        this.Top = this.Top + N;
    }
    public void Shuffle(){
        for(int i = 0; i<52; i++){
            if(this.cards[i].Order!=-1){
                while(true){
                    Random Rand = new Random();
                    int randInt = Rand.nextInt(52);
                    if(this.cards[randInt].Order != -1){

                        Card Temp1 = new Card(this.cards[randInt].Suits, this.cards[randInt].numRank, this.cards[i].Order);
                        Card Temp2 = new Card(this.cards[i].Suits, this.cards[i].numRank, this.cards[randInt].Order);
                        this.cards[randInt] = Temp2;
                        this.cards[i] = Temp1;
                        break;
                    }
                }
            }
        }
    }

    public void Restore(int N){
        for(int i = 0; i < 52; i++){
            if(this.cards[i].Order == - 1){
                this.cards[i].Order = this.Bot + 1;
                this.Bot = this.Bot + 1;
            }
        }
    }

    public String toString(){
        String wholedeck = "";
        for (int i = this.Top; i < this.Bot+1; i++)
        {
            for (int j = 0; j < 52; j++){
                if (this.cards[j].Order == i){
                    wholedeck += this.cards[j].numRank + " Of " + this.cards[j].Suits + "\n";
                }
            }
        }
        return wholedeck;
    }
}