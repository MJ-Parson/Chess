package Chess.Game.Pieces;

public enum Team{
    WHITE{
        @Override
        public String toString() {
            return "White";
        }
    },
    BLACK {
        @Override
        public String toString() {
            return "Black";
        }
    },
    NOCOLOR {
        @Override
        public String toString() {
            return "No Color";
        }
    };
}
