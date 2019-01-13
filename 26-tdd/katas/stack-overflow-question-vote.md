### Stack Overflow Question Voting using TDD

We want to model the question voting behavior on Stack Overflow.

Remember that we focus **only** on question voting behavior - nothing more. 
We don't care about the infrastructure layer here. Business logic is our only
 concern in this kata.

#### Requirements

Try to follow these requirements step-by-step, writing only the code required
 to implement the current and previous steps. Do not think ahead.

1. Question can be upvoted by any user (except of the author), but no more than 
once
2. Question can be downvoted by any user (except of the author), but no 
more than once
3. When question is upvoted/downvoted, it can be downvoted/upvoted again by 
the same user to change the state to "neutral" (as if the user never voted)