import React from 'react';
import pure from 'recompose/pure'


function MemberInterface({success, error, pressEnter, changeName, doChangeName, originalName, drawName}) {

    return (
        <div className="MemberInterface">

            <div className="form-signin">
                {error ?
                    <div>{error}</div>
                    :
                    null
                }
                {success ?
                    <div>{success}</div>
                    :
                    null
                }
                <h2 className="form-heading">Change name</h2>
                <div className={"form-group" + error !== null ? 'hasError' : ''}>
                    <div className="form-group ">
                        <input name="username" type="text"
                               className="form-control"
                               placeholder="Name"
                               onChange={changeName.bind(this)}
                               onKeyPress={pressEnter.bind(this)}
                               value={drawName ? drawName : ""}
                               autoFocus="true"/>
                        <button className="btn btn-lg btn-primary btn-block"
                                disabled={originalName === drawName}
                                onClick={doChangeName.bind(this)}>
                            {originalName === drawName ?
                                <span>Already have that name</span>
                                :
                                <span>Change name</span>
                            }
                        </button>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default pure(MemberInterface)