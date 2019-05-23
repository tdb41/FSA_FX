start(0).
accept(1).
accept(3).

move(0,0,x).
move(0,1,y).
move(1,2,x).
move(2,2,x).
move(2,3,y).
move(3,3,x).
move(3,4,z).
move(4,4,x).
move(4,1,a).


recog(State,[]) :-
accept(State).

recog(State1,String) :-
move(State1,State2,Letter),
step(Letter,String,NewString),
recog(State2,NewString).

step(Letter,[Letter|TString],TString).


fsa(TString) :-
start(State),
recog(State,TString).


good :- fsa([x,y,x,x,y,x,z,a]).
bad :- fsa([x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,a]).
