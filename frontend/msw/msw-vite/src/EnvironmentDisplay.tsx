import React from 'react';

const EnvironmentDisplay = () => {
  console.log('NODE_ENV:', process.env.NODE_ENV);

  return (
    <div>
      <p>Current Environment: {process.env.NODE_ENV}</p>
    </div>
  );
};

export default EnvironmentDisplay;