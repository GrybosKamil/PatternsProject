import React from 'react';
import pure from 'recompose/pure'


function Challenges({success, error, challenges}) {

    console.log(challenges);
    const challengesList = challenges.map((challenge, key) => {
        return (
            <div key={key}>
                <span>{challenge.owner.name}</span>
                <span>{challenge.name}</span>
                {/*<span>{challenge.description}</span>*/}
                <ul>
                    {challenge.rewards.map((reward, key2) => {
                        return (
                            <li key={key2}>{reward.amount} {reward.currency}</li>
                        )
                    })}
                </ul>
            </div>
        )
    });

    return (
        <div className="Challenges">

            {challengesList}
        </div>
    )
}

export default pure(Challenges)