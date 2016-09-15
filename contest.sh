mkdir -p -- "$1";
cat Solution.java >> "$1"/"Solution.java";
cat Makefile >> "$1"/"Makefile";
cd -- "$1";
touch -- "in";
touch -- "out";
